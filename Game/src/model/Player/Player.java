package model.Player;

import model.Pack.Pack;

public class Player {

    private String name;
    private ColorPlayer color;
    private Pack toHand;
    private int useAbility;
    private int score;
    private boolean hasPlayed;

    /**
     * <b>constructor</b>: Constructs a new Player with the given
     * parameter name ID and color.<br />
     * <b>postcondition</b>: Creates and initializes a player with the given
     * name ID and color.Also initializes some variables (from example the score)
     * if player has started or finished in a game
     * @param name is the name of the player.
     * @param color is the color of the player
     */
    public Player (String name, ColorPlayer color){
        this.name=name;
        this.color=color;
        toHand=new Pack();
        this.useAbility=0;
        this.score=0;
        this.hasPlayed=false;
    }


    /**
     * <b>transformer</b>: sets the name of the player to newName <br />
     * <p><b>Postcondition:</b> the name of this player is changed to newName</p>
     * @param newName the new name of the player
     */
    public void setName(String newName)
    {
        this.name = newName;
    }


    /**
     * <b>accessor(selector)</b>:Returns the name of the player <br />
     * <p><b>Postcondition:</b> returns the name of the player </p>
     * @return the the name of the player
     */
    public String getName()
    {
        return name;
    }


    /**
     * <b>accessor(selector)</b>: Returns the color of a player. <br />
     * <b>postcondition</b>: Returns the color of the player.
     * @return the color of the player
     */
    public ColorPlayer getColor(){return color;}


    /**
     * <b>transformer(mutative)</b>: It sets the color of a player <br />
     * <b>postcondition</b>:the color of the player is changed to id
     * @param color the new color of the player
     */
    public void setColor(ColorPlayer color){this.color=color;}


    /**
     * <b>transformer</b>: sets the Pack of a player <br />
     * <p><b>Postcondition:</b>  Pack(collection) of this player is changed to toHand</p>
     * @param toHand
     *
     */
    public void setPack_to_play(Pack toHand){}


    /**
     * <b>accessor</b>
     * <p><b>Postcondition:</b> returns the tiles of a player </p>
     * @return the tiles of player
     */
    public Pack getPack_to_play()
    {
        return this.toHand;
    }


    /**
     * <b>transformer</b>:calculates the score of a Player <br />
     * <p><b>Postcondition</b> Score of the player has calculated</p>
     */
    public void calculateScore(){}


    /**
     * <b>accessor</b>
     * <p><b>Postcondition:</b> returns the score of the player</p>
     * @return the score of the player
     */
    public int getScore(){return this.score;}


    /**
     * <b>transformer</b>:sets the optional action to truth or false <br />
     * <p><b>Postcondition</b> useAbility has chacnged</p>
     */
    public void setUseAbility(int useAbility){this.useAbility=useAbility;}


    /**
     * <b>accessor</b>
     * <p><b>Postcondition:</b> returns the useAbility of the player</p>
     * @return the useAbility of the player
     */
    public int getUseAbility(){return this.useAbility;}


    /**
     * <b>transformer</b>:if useAbility=1 the Player uses the ability of one of his character else it doesn't do nothing
     * <p><b>Precondition</b></p>:The character that the Player wants to use his ability must exist
     * <p><b>Postcondition</b></p>:Use the ability of the character
     */
    public void UseAbility(int useAbility){
        if(useAbility==1){

        }
    }


    /**
     * <b>transformer</b>: sets the variable hasplayed to true
     * <p><b>Postcondition:</b>  sets the variable hasplayed to true</p>
     */

    public void setHasPlayed(){}


    /**
     * <b>Observer</b>:Returns if a player has played at least one time <br />
     * <p><b>Postcondition:</b> Returns if a player has played at least one time </p>
     * @return true if a player has played at least one time false otherwise
     */
    public boolean getHasPlayed()
    {
        return this.hasPlayed;
    }


}
