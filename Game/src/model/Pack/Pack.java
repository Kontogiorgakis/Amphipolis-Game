package model.Pack;

import model.Tile.*;
import model.Character.Character;

import java.util.ArrayList;
import java.util.Collections;


public class Pack {
    private ArrayList<Tile> tiles;
    private ArrayList<Character> characters;


    /**
     * Constructor
     * <b>Postcondition</b>Creates a new Hand with a new cards from tiles.
     */
    public Pack(){
        tiles=new ArrayList<>();
        characters=new ArrayList<>();

    }


    /**
     * <b>Observers:</b> Adds a tile to the list.
     * <b>Postconditions:</b> A tile has been added to the list.
     * @params i
     */
    public void addTile(Tile i){tiles.add(i);}


    /**
     * <b>Observers:</b> Adds a character to the list.
     * <b>Postconditions:</b> A character has been added to the list.
     * @params i
     */
    public void addCharacter(Character i){characters.add(i);}


    /**
     * <b>Accessors:</b> returns from the list the tile
     * <b>Postconditions:</b> tile from the list has been returned
     * @param i
     * @returns a tile
     */
    public Tile getTiLe(int i){return tiles.get(i);}


    /**
     * <b>Accessors:</b> returns from the list the character
     * <b>Postconditions:</b> character from the list has been returned
     * @param i
     * @returns a character
     */
    public Character getCharacter(int i){return characters.get(i);}


    /**
     * <b>Transformers:</b> Removes a tile from list.
     * <b>Postcondition:</b> A tile has been removed list.
     * @params i
     */
    public void removeTile(int i){
        tiles.remove(i);
    }


    /**
     * <b>Transformers:</b> Removes a character from list.
     * <b>Postcondition:</b> A character has been removed list.
     * @params i
     */
    public void removeCharacter(Character i){characters.remove(i);}


    /**
     * <b>Accessors:</b> returns the tile list
     * <b>Postconditions:</b> tile list has been returned
     * @return tile list
     */
    public ArrayList<Tile> getListTile(){return  this.tiles;}


    /**
     * <b>Accessors:</b> returns the character list
     * <b>Postconditions:</b> character list has been returned
     * @return character list
     */
    public ArrayList<Character> getListCharacter(){return this.characters;}


    /**
     * <b>Transformer:</b> shuffles tiles randomly
     * <b>postcondition:</b> tiles has been successfully shuffled
     */
    public void shuffleTiles() {
        Collections.shuffle(tiles);
    }

}
