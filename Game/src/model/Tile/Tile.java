package model.Tile;

import java.awt.image.BufferedImage;

public abstract interface Tile {

    /**
     * <b>Accessor:</b> returns the tile's image
     * <b>Postcondition:</b> tile's image has been returned
     * @returns tile's image
     */
    public BufferedImage getTileImage();


    /**
     * <b>Accessor:</b> returns the tile's type
     * <b>Postcondition:</b> tile's type has been returned
     * @return string type
     */
    public String getType();

    /**
     * <b>Transformer:</b> sets the tile's type
     * <b>Postcondition:</b> tile's type has been set
     * @param type
     */
    public void setType(String type);


    /**
     * Returns the string representation of a tile
     * <p><b>Postcondition:</b> The string representation of a tile is returned</p>
     * @return The string representation of a tile
     */
    @Override
    public String toString();

}
