package enigma;

public class Rotor {

    private int position;
    private int[] cipher = new int[26];
    private int[] bcipher = new int[26];
    private int notch1 = -1;
    private int notch2 = -1;

    //Getter of the attributes position
    
    public int getPosition() {
        return position;
    }

    //Setter of the attributes position
    
    public void setPosition(int posn) {
        position = posn;
    }

    /*
        This function remove the spaces in a string given in parameters and ciphaer the string
    */
    public static Rotor rotorFactory(String str, String notches){
            char[] s = str.trim().replace(" ", "").toCharArray();
            int[] cipher = new int[26];
            for (int i = 0; i< 26; i++){
                    cipher[i] = toIndex(s[i]);
            }
            s = notches.trim().replace(" and ", "").toCharArray();
            if (s.length == 2){
                    return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
            } else {
                    return new Rotor(cipher, toIndex(s[0]));
            }

    }

    private Rotor(int[] c, int notch1, int notch2) {
            this.notch1 = notch1;
            this.notch2 = notch2;
            cipher = c;
            createBCipher();
    }

    private Rotor(int[] c, int notch1) {
            this.notch1 = notch1;
            cipher = c;
            createBCipher();
    }

    protected Rotor() {

    }

    //The 2 following functions permit to covert a letter depending on the cipher
    
    public int convertForward(int p) {
        return ((cipher[((p+position)%26+26)%26]-position)%26+26)%26;
    }

    public int convertBackward(int e) {
        return ((bcipher[((e+position)%26+26)%26]-position)%26+26)%26;
    }
    
    //This function permit to turn the rotor
    
    public void advance() {
        position = (position+1) % 26;
    }
    
    protected boolean atNotch() {
        return (position == notch1 || position == notch2);
    }

    protected static char toLetter(int p) {
        return (char)(p + 'A');
    }

    protected static int toIndex(char c) {
        return c - 'A';
    }
    
	private void createBCipher() {
		for(int i =0; i<26; i++)
			bcipher[cipher[i]] = i;
	}



}
