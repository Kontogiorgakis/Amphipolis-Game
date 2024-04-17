package model.Tile;

import java.awt.image.BufferedImage;

public class Skeletons implements Tile{

    private String type;
    private BufferedImage image;
    private boolean bigSize;
    private boolean smallSize;
    private boolean upperBody;
    private boolean lowerBody;


    /**
     * Constructor.
     * <b>Postcondition</b> Creates a new Skeleton with type 'type', and also we initialize him as false
     * @param type
     * @param bigSize
     * @param smallSize
     * @param upperBody
     * @param lowerBody
     */
    public Skeletons(String type, BufferedImage image, boolean bigSize, boolean smallSize, boolean upperBody, boolean lowerBody){
        this.type=type;
        this.image=image;
        this.bigSize=false;
        this.smallSize=false;
        this.upperBody=false;
        this.lowerBody=false;
    }

    /**
     *<b>Transformer:</b> sets big size equals true
     *<b>Postcondition:</b> skeleton's size has been set
     */
    public void isBigSize(){
        this.bigSize=true;
        //return true;
    }


    /**
     * <b>Accessor:</b> returns the boolean value of bigSize
     * <b>Postcondition:</b> boolean value of bigSize has been returned
     * @return boolean value of bigSize
     */
    public boolean getisBigSize(){
        return bigSize;
    }


    /**
     *<b>Transformer:</b> sets small size equals true
     *<b>Postcondition:</b> skeleton's size has been set
     */
    public void isSmallSize(){
        this.smallSize=true;
        //return true;
    }


    /**
     * <b>Accessor:</b> returns the boolean value of smallSize
     * <b>Postcondition:</b> boolean value of smallSize has been returned
     * @return boolean value of smallSize
     */
    public boolean getisSmallSize(){
        return smallSize;
    }


    /**
     *<b>Transformer:</b> sets upper body equals true
     *<b>Postcondition:</b> skeleton's body has been set
     */
    public void isUpperBody(){
        this.upperBody=true;
        //return true;
    }


    /**
     * <b>Accessor:</b> returns the boolean value of upperBody
     * <b>Postcondition:</b> boolean value of upperBody has been returned
     * @return boolean value of upperBody
     */
    public boolean getisUpperBody(){
        return upperBody;
    }


    /**
     *<b>Transformer:</b> sets lower body equals true
     *<b>Postcondition:</b> skeleton's body has been set
     */
    public void isLowerBody(){
        this.lowerBody=true;
        //return true;
    }


    /**
     * <b>Accessor:</b> returns the boolean value of lowerBody
     * <b>Postcondition:</b> boolean value of lowerBody has been returned
     * @return boolean value of lowerBody
     */
    public boolean getisLowerBody(){
        return lowerBody;
    }


    /**
     * <b>Accessor:</b> returns the tile's image
     * <b>Postcondition:</b> tile's image has been returned
     * @returns tile's image
     */
    @Override
    public BufferedImage getTileImage(){return image;}


    /**
     * <b>Accessor:</b> returns the tile's type
     * <b>Postcondition:</b> tile's type has been returned
     * @return string type
     */
    @Override
    public String getType(){
        return type;
    }


    /**
     * <b>Transformer:</b> sets the tile's type
     * <b>Postcondition:</b> tile's type has been set
     * @param type
     */
    @Override
    public void setType(String type){

    }


    /**
     * Returns the string representation of a tile
     * <p><b>Postcondition:</b> The string representation of a tile is returned</p>
     * @return The string representation of a tile
     */
    @Override
    public String toString(){return (this.type);}
}
