package model.Tile;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class Amphores implements Tile{

    private ColorAmphores col;
    private BufferedImage image;
    private String type;


    /**
     * Constructor.
     *
     * <b>Postcondition</b> Creates a new Amphorea with color 'col' and type 'type'
     * @param  col
     */
    public Amphores(ColorAmphores col, BufferedImage image, String type){
        this.type=type;
        this.image=image;
        this.col=col;
    }


    /**
     * <b>Accessor:</b> returns the tile's (amphoreas) color
     * <b>Postcondition:</b> tile's (amphoreas) color has been returned
     * @return the tile's (amphoreas) color
     */
    public ColorAmphores getColor(){
        return col;
    }


    /**
     * <b>Transformer:</b> sets the tile's (amphoreas) color
     * <b>Postcondition:</b> the tile's (amphoreas) color has been set
     * @param  col
     */
    public void setColor(ColorAmphores col) {
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
