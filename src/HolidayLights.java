import itsc2214.Node;
/**
 * A class that implements a chain of lights for
 * the holidays. Each chain contains initially 5
 * but you can remove some or change some by
 * colors.
 *
 * @author jbroo129@charlotte.edu
 * @author blacroi2@charlotte.edu
 * @author rlacroix@charlotte.edu
 * @author adibern2@charlotte.edu
 * @author ahooker9@charlotte.edu
 */

class LightChain {

    /**
     * Use these constants in the main program to pass
     * a color to the routines in this file. When you
     * print this string, the output will set the 
     * background of the appropriate color.
     */

    /** LightChain.RED. */
    final static String RED    = "\u001b[41m Red  \u001b[0m";

    /** LightChain.GREEN. */
    final static String GREEN  = "\u001b[42mGreen \u001b[0m";

    /** LightChain.YELLOW. */
    final static String YELLOW = "\u001b[43mYellow\u001b[0m";

    /** LightChain.BLUE. */
    final static String BLUE   = "\u001b[44m Blue \u001b[0m";

    /** LightChain.ORANGE. */
    final static String ORANGE = "\u001b[41mOrange\u001b[0m";

    /** LightChain.PURPLE. */
    final static String PURPLE = "\u001b[45mPurple\u001b[0m";

    /** LightChain.WHITE. */
    final static String WHITE  = "White";

    /**
     * The reference to the beginning light node of this chain.
     */
    protected Node<String> headOfLightString;

    /**
     * Constructor, build a chain of lights: Red,Green,Blue,Yellow,White,
     * initializing the instance variable, headOfLightString
     */
    public LightChain() {
        Node<String> white = new Node<String>(WHITE);
        Node<String> yellow = new Node<String>(YELLOW,white);
        Node<String> blue = new Node<String>(BLUE,yellow);
        Node<String> green = new Node<String>(GREEN,blue);
        headOfLightString = new Node<String>(RED,green);
    }

    /**
     * Returns the color of the light bulb at
     * position x.
     * @param pos position of the bulb to get
     * @return color
     */
    public String get(int pos) {
        Node<String> cur = headOfLightString;
        while (cur != null && pos > 0) {
            pos--;
            cur = cur.getNext();
        }
        if (cur != null) {
            return cur.getData();
        }
        else {
            return null;
        }
    }

    /**
     * Join two LightChains by connecting anotherPiece
     * to the end of this one.
     * 
     * @param anotherPiece a LightChain to append to this one
     * @return this chain, appropriate for doing multiple chaining
     */
    public LightChain join(LightChain anotherPiece) {
        Node<String> cur = headOfLightString;
        while (cur.getNext() != null) {
            cur = cur.getNext();
        }
        cur.setNext(anotherPiece.headOfLightString);
        return this;
    }

    /**
     * Traverse the light chain, printing the node 
     * value for each.
     */
    public void traverseLightChain() {
        Node<String> current = headOfLightString;
        while(current.getNext() != null){
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    /**
     * Insert the newColor after another color (afterColor).
     * @param newColor   the color to be inserted
     * @param afterColor insert it after this color
     */
    public void insertAfter(String newColor, String afterColor) {
        Node<String> current = headOfLightString;
        Node<String> found = null;
        while (current.getNext() != null) {
             
            if (current.getData().equals(afterColor)) {
                found = current;
                break;
            }
            current = current.getNext();
        }
        if (found == null) return;
 
        Node<String> next = found.getNext();
        current.setNext(new Node<String>(afterColor, next));
    }

    /**
     * Remove the given color.
     * @param aColor the to-be-removed color
     */
    public void remove(String aColor) {
        Node<String> current = headOfLightString;
    }
    
    /**
     * Replaces all colors acolor with anotherColor.
     * @param aColor the color to be replaced.
     * @param anotherColor the color that will replace it.
     */
    public void replaceAll(String aColor, String anotherColor) {
        //TODO Replace all lightbulbs of a color light with another light.
        
        Node<String> current = headOfLightString;
        
    }

}

