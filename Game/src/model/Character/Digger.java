package model.Character;

import java.awt.image.BufferedImage;

public class Digger implements Character{

    private boolean isUsed;
    private String type;
    private BufferedImage image;

    public Digger(String type, BufferedImage image){
        this.type=type;
        this.image= image;
        this.isUsed=false;
    }


    /**
     *<b>transformer</b>: sets the type of the character <br />
     *<p><b>Postcondition:</b> the the type of the character has been set</p>
     * @param type
     */
    @Override
    public void setType(String type){}


    /**
     * <b>accessor</b>:Returns the type of the cahracter list <br />
     * <p><b>Postcondition:</b> the the type of the character has been returned</p>
     * @return the type of the character
     */
    @Override
    public String getType(){
        return type;
    }


    /**
     * <b>Accessor:</b> returns the character's image
     * <b>Postcondition:</b> character's image has been returned
     * @returns character's image
     */
    @Override
    public BufferedImage getCharacterImage(){return image;}


    /**
     *<b>transformer</b>: sets true if the ability is used else false <br />
     *<p><b>Postcondition:</b>the boolean value of abilityIsUsed has been set</p>
     */
    @Override
    public void setabilityIsUsed(){this.isUsed=false;}


    /**
     * <b>accessor</b>:Returns true if the ability is used else false <br />
     * <p><b>Postcondition:</b> the boolean value of abilityIsUsed</p>
     * @return the boolean value of abilityIsUsed
     */
    @Override
    public boolean getabilityIsUsed(){return isUsed;}


    /**
     * <b>Transformer</b>: Uses the ability of the character if it isn't used
     * <p><b>Postcondition:</b> the ability of the character has been used</p>
     */
    @Override
    public void ability(){}


    /**
     * Returns the string representation of a character
     * <p><b>Postcondition:</b> The string representation of a character is returned</p>
     * @return The string representation of a character
     */
    @Override
    public String toString(){return (this.type);};
}
