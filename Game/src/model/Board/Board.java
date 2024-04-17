package model.Board;

import model.Character.Character;
import model.Tile.*;

import java.util.ArrayList;

public class  Board {


    private ArrayList<Tile> locationMosaics;
    private ArrayList<Tile> locationStatues;
    private ArrayList<Tile> locationAmphores;
    private ArrayList<Tile> locationSkeletons;
    private ArrayList<Tile> locationEntrance;



    /**
     * Constructor
     * <b>Postcondition</b>Creates a new Hand with a new cards from tiles.
     */
    public Board(){
        locationMosaics=new ArrayList<>();
        locationStatues=new ArrayList<>();
        locationAmphores=new ArrayList<>();
        locationSkeletons=new ArrayList<>();
        locationEntrance=new ArrayList<>();
    }

    /**
     * <b>Observers:</b> Adds a mosaic to locationMosaic.
     * <b>Postconditions:</b> A mosaic has been added to locationMosaic.
     */
    public void setLocationMosaics(Tile i){
        locationMosaics.add(i);
    }


    /**
     * <b>Accessor:</b> Gets the specific mosaic from the location
     * <b>Postcondition:</b> A mosaic has been returned
     * @param i
     * @return the specific mosaic from the location
     */
    public Tile getLocationMosaics(int i){return locationMosaics.get(i);}


    /**
     * <b>Transformers:</b> Removes a tile from the location
     * <b>Postcondition:</b> A tile has been removed from the location
     * @param i
     */
    public void removeLocationMosaics(Tile i){
        locationMosaics.remove(i);
    }


    /**
     * <b>Accessor:</b> Gets all the mosaicList from the location
     * <b>Postcondition:</b> The mosaicList from the location has been returned
     * @return the mosaicList from the location
     */
    public ArrayList<Tile> getListLocationMosaics(){return this.locationMosaics;}


    /**
     * <b>Observers:</b> Adds a statue to locationStatues.
     * <b>Postconditions:</b> A statue has been added to locationStatue.
     */
    public void setLocationStatues(Tile i){
        locationStatues.add(i);
    }


    /**
     * <b>Accessor:</b> Gets the specific statue from the location
     * <b>Postcondition:</b> A statue has been returned
     * @param i
     * @return the specific statue from the location
     */
    public Tile getLocationStatues(int i){return locationStatues.get(i);}


    /**
     * <b>Transformers:</b> Removes a tile from the location
     * <b>Postcondition:</b> A tile has been removed from the location
     * @param i
     */
    public void removeLocationStatues(Tile i){
        locationStatues.remove(i);
    }


    /**
     * <b>Accessor:</b> Gets all the statueList from the location
     * <b>Postcondition:</b> The statueList from the location has been returned
     * @return the statueList from the location
     */
    public ArrayList<Tile> getListLocationStatues(){return this.locationStatues;}


    /**
     * <b>Observers:</b> Adds a amphoreas to locationAmphoreas.
     * <b>Postconditions:</b> A amphoreas has been added to locationAmphores.
     */
    public void setLocationAmphores(Tile i){
        locationAmphores.add(i);
    }


    /**
     * <b>Accessor:</b> Gets the specific amphoreas from the location
     * <b>Postcondition:</b> A amphoreas has been returned
     * @param i
     * @return the specific amphoreas from the location
     */
    public Tile getLocationAmphores(int i){return locationAmphores.get(i);}


    /**
     * <b>Transformers:</b> Removes a tile from the location
     * <b>Postcondition:</b> A tile has been removed from the location
     * @param i
     */
    public void removeLocationAmhpores(Tile i){
        locationAmphores.remove(i);
    }


    /**
     * <b>Accessor:</b> Gets all the amphoresList from the location
     * <b>Postcondition:</b> The amphoresList from the location has been returned
     * @return the amphoresList from the location
     */
    public ArrayList<Tile> getListLocationAmphores(){return this.locationAmphores;}


    /**
     * <b>Observers:</b> Adds a skeleton to locationSkeletons.
     * <b>Postconditions:</b> A skeleton has been added to locationSkeletons.
     */
    public void setLocationSkeletons(Tile i){
        locationSkeletons.add(i);
    }


    /**
     * <b>Accessor:</b> Gets the specific skeleton from the location
     * <b>Postcondition:</b> A skeleton has been returned
     * @param i
     * @return the specific skeleton from the location
     */
    public Tile getLocationSkeletons(int i){return locationSkeletons.get(i);}


    /**
     * <b>Transformers:</b> Removes a tile from the location
     * <b>Postcondition:</b> A tile has been removed from the location
     * @param i
     */
    public void removeLocationSkeletons(Tile i){
        locationSkeletons.remove(i);
    }


    /**
     * <b>Accessor:</b> Gets all the skeletonList from the location
     * <b>Postcondition:</b> The skeletonList from the location has been returned
     * @return the skeletonList from the location
     */
    public ArrayList<Tile> getListLocationSkeletons(){return this.locationSkeletons;}


    /**
     * <b>Observers:</b> Adds a landslide to locationEntrance.
     * <b>Postconditions:</b> A mosaic has been added to locationEntrance.
     */
    public void setLocationEntrance(Tile i){
        locationEntrance.add(i);
    }


    /**
     * <b>Accessor:</b> Gets the specific landslide from the location
     * <b>Postcondition:</b> A landslide has been returned
     * @param i
     * @return the specific landslide from the location
     */
    public Tile getLocationEntrance(int i){return locationEntrance.get(i);}


    /**
     * <b>Accessor:</b> Gets all the landslideList from the location
     * <b>Postcondition:</b> The landslideList from the location has been returned
     * @return the landslideList from the location
     */
    public ArrayList<Tile> getListLocationEntrance(){return this.locationEntrance;}


    /**
     * <b>Accessor:</b>Returns true if the Entrance is full else false
     * <b>Postcondotion:</b>The boolean value of the isEntranceLocationFull is returned
     * @return the boolean value of the isEntranceLocationFull
     */
    public boolean isEntranceLocationFull(){return false;}

}
