package edu.macalester.comp124.stringtransformer;

import acm.program.Program;
import org.reflections.Reflections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;


public class TransformerTestUI extends Program {
    
    private List<StringTransformer> transformers;
    private StringTransformer selectedTransformer;
    private String sampleText;

    private static String SAMPLE_TEXT = "As Gregor Samsa awoke one morning from uneasy " +
            "dreams he found himself transformed in his bed into a gigantic insect. " +
            "He was lying on his hard, as it were armor-plated, back and when he " +
            "lifted his head a little he could see his domelike brown belly divided " +
            "into stiff arched segments on top of which the bed quilt could hardly " +
            "stay in place and was about to slide off completely. " +
            "His numerous legs, which were pitifully thin compared to the rest of his " +
            "bulk, waved helplessly before his eyes.";

    private static String SAMPLE_TWO = "It was the best of times, it was the worst of times," +
            "it was the age of wisdom, " +
            "it was the age of foolishness, " +
            "it was the epoch of belief, " +
            "it was the epoch of incredulity, " +
            "it was the season of Light, " +
            "it was the season of Darkness, " +
            "it was the spring of hope, " +
            "it was the winter of despair, " +
            "we had everything before us, we had nothing before us, we were all going direct to Heaven," +
            "we were all going direct the other way— in short, the period was so far like the present period," +
            " that some of its noisiest authorities insisted on its being received, for good or for evil, in " +
            "the superlative degree of comparison only." +
            "There were a king with a large jaw and a queen with a plain face, on the throne of England; there " +
            "were a king with a large jaw and a queen with a fair face, on the throne of France. In both " +
            "countries it was clearer than crystal to the lords of the State preserves of loaves and fishes, " +
            "that things in general were settled for ever.";
    
    private JTextPane sampleTextPane;
    private JComboBox transformerChooser;

    public void run() {
        loadTransformers();
        loadSampleText();
        createUI();
        selectDefaultTransformer();
    }

    private void loadTransformers() {
        transformers = new ArrayList<StringTransformer>();
        
        // Find and instantiate all subclasses of StringTransformer in this package
        Reflections reflections = new Reflections(getClass().getPackage().getName());
        for(Class<? extends StringTransformer> transformerClass : reflections.getSubTypesOf(StringTransformer.class)) {
            try {
                transformers.add(transformerClass.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Cannot instantiate " + transformerClass, e);
            }
        }
        
        // Alphabetize
        Collections.sort(transformers, new Comparator<StringTransformer>() {
            @Override
            public int compare(StringTransformer t0, StringTransformer t1) {
                return t0.toString().compareTo(t1.toString());
            }
        });
        
        transformers = Collections.unmodifiableList(transformers);
    }

    private void loadSampleText() {
        sampleText = new Scanner(SAMPLE_TWO)
            .useDelimiter("\\A").next();
    }

    private void createUI() {
        transformerChooser = new JComboBox(transformers.toArray());
        transformerChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                selectedTransformer = (StringTransformer) transformerChooser.getSelectedItem();
                updateTransformerOutput();
                saveDefaultTransformer();
            }
        });
        add(transformerChooser, NORTH);
        
        sampleTextPane = new JTextPane();
        sampleTextPane.setFont(new Font("Palatino", Font.PLAIN, 18));
        add(new JScrollPane(sampleTextPane), CENTER);
        validate();
    }

    private void updateTransformerOutput() {
        sampleTextPane.setText(
            (selectedTransformer == null)
                ? ""
                : selectedTransformer.transformEachWord(sampleText));
    }
    
    private void selectDefaultTransformer() {
        String selection = prefs().get("selectedTransformer", null);
        for(StringTransformer transformer : transformers) {
            if(transformer.getClass().getName().equals(selection)) {
                transformerChooser.setSelectedItem(transformer);
                return; 
            }
        }
        transformerChooser.setSelectedIndex(0); // no selection saved, or selection no longer present
    }
    
    private void saveDefaultTransformer() {
        Preferences prefs = prefs();
        prefs.put("selectedTransformer", selectedTransformer.getClass().getName());
        try {
            prefs.sync();
        } catch (BackingStoreException e) {
            // No reason to stop execution for this one
            e.printStackTrace();
        }
    }

    private Preferences prefs() {
        return Preferences.userRoot().node(getClass().getName());
    }
}

