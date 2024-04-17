package model.Tile;


import java.awt.image.BufferedImage;

public class Sphinxes implements Tile{

    private String type;
    private BufferedImage image;


    /**
     * Constructor.
     *
     * <b>Postcondition</b> Creates a new Sphinx with type 'type'
     * @param  type
     */
    public Sphinxes(String type, BufferedImage image){
        this.type=type;
        this.image=image;
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
