package model.Tile;

import java.awt.image.BufferedImage;

public class Mosaics implements Tile{

    private ColorMosaics col;
    private BufferedImage image;
    private String type;

    /**
     * Constructor.
     *
     * <b>Postcondition</b> Creates a new Mosaic with color 'col' and type 'type'
     * @param col
     */
    public Mosaics(ColorMosaics col, BufferedImage image, String type){
        this.col=col;
        this.image=image;
        this.type=type;
    }


    /**
     * <b>Accessor:</b> returns the tile's (mosaic) color
     * <b>Postcondition:</b> tile's (mosaic) color has been returned
     * @return the tile's color
     */
    public ColorMosaics getColor(){
        return this.col;
    }


    /**
     * <b>Transformer:</b> sets the tile's (mosaic) color
     * <b>Postcondition:</b> the tile's (mosaic) color has been set
     * @param  col
     */
    public void setColor(ColorMosaics col) {
        this.col=col;
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
    public String toString(){return (this.type+" "+this.col);}
}
