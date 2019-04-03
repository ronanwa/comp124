Specification for String transformers
===

Each specification is for a particular **word**.

### Capitalizer

First character capitalized, others are unchanged.

### IMIfier

Vowels are removed, all characters are converted to lowercase, and 20% of words are followed by a randomly selected choice between `lol`, `lmao`, `omg`, `jk`, or `rofl`.

### L33t

Translate letters to their closest digits: `e` -> `3`, `a` -> `4`, `o` -> `0`, etc.

### PigLatinizer

 * If the word begins with a consonant -- e.g., `string`, `latin` -- divide the word at the first vowel, swapping the front and back halves and append `ay` to the word -- i.e., `ingstray`, `atinlay`.
 * If the word begins with a vowel -- e.g., `am`, `are`, `i` -- append `yay` to the word -- i.e., `amyay`, `areyay`, `iyay`.
 * If the word has no vowels (other than `y`) -- e.g., `my`, `thy` -- append `yay` to it -- i.e., `myyay`, `thyyay`.

### Piratizer

All `r`s are changed to `rrr`s. 25% of sentences end with a random choice between `Arrrrr!` and `Ahoy!`.

### Reverser

The characters in each word are reversed.

### Sidney, 3 years

Every internal `l` (not first or last character of word) is replaced with a `y`. `S`s that start a word and are followed by a second non-`s` consonant are dropped.

### Stella, 1 year

Every consecutive string of consonants are replaced with a single `g`, `m` or `b`. Long words are cut off starting at the third set of consonants.

### Scrambler

The letters in each word are shuffled and appear in a random order.

### VowelBleeper

All vowels are bleeped out with asterisks.




