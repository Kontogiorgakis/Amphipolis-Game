package model.Character;

import java.awt.image.BufferedImage;

public abstract interface Character {

    /**
     *<b>transformer</b>: sets the type of the character <br />
     *<p><b>Postcondition:</b>the type of the character has been set</p>
     * @param type
     */
    public void setType(String type);


    /**
     * <b>accessor</b>:Returns the type of the character list <br />
     * <p><b>Postcondition:</b>the type of the character has been returned</p>
     * @return the type of the character
     */
    public String getType();


    /**
     * <b>Accessor:</b> returns the character's image
     * <b>Postcondition:</b> character's image has been returned
     * @returns character's image
     */
    public BufferedImage getCharacterImage();


    /**
     *<b>transformer</b>: sets true if the ability is used else false <br />
     *<p><b>Postcondition:</b>the boolean value of abilityIsUsed has been set</p>
     */
    public void setabilityIsUsed();


    /**
     * <b>accessor</b>:Returns true if the ability is used else false <br />
     * <p><b>Postcondition:</b> the boolean value of abilityIsUsed is returned</p>
     * @return the boolean value of abilityIsUsed
     */
    public boolean getabilityIsUsed();


    /**
     * <b>Transformer</b>: Uses the ability of the character if it isn't used
     * <p><b>Postcondition:</b> the ability of the character has been used</p>
     */
    public void ability();


    /**
     * Returns the string representation of a character
     * <p><b>Postcondition:</b> The string representation of a character is returned</p>
     * @return The string representation of a character
     */
    @Override
    public String toString();
}
