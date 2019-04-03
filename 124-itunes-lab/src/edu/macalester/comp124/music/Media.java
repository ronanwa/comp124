package edu.macalester.comp124.music;

/**
 * A media object in an iTunes library that may be a podcast, song, video, etc.
 * 
 * @author shilad
 */
public class Media {
    private String filePath;
    private String name;
    private int count;

    public Media(String filePathA, String nameA, int countA) {
        filePath = filePathA;
        name = nameA;
        count = countA;
    }

    public Media(String filePathA, String nameA){
        this(filePathA, nameA, 0);
    }

    public String getFilePath(){
        return filePath;
    }

    public String getName(){
        return name;
    }

    public int getCount(){
        return count;
    }

    /**
     * Returns true iff the media object matches the search query.
     */
	public boolean matchesQuery(String query) {
		return getName().toLowerCase().contains(query.toLowerCase());
	}

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof Media)){
            return false;
        }

        Media media = (Media) other;
        return (filePath.equals(media.filePath) && name.equals(media.name));
    }

    public String toString() {
        return filePath+" "+name;  // TODO: FIXME
    }

}
