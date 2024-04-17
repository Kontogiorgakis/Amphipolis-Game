package controller;

import model.Board.Board;
import model.Character.*;
import model.Pack.Pack;
import model.Player.ColorPlayer;
import model.Player.Player;
import model.Tile.*;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Controller {
    private Archaeologist archaeologist;
    private Assistant assistant;
    private Digger digger;
    private Professor professor;
    private Board board = new Board();
    private final ColorPlayer[] colors;
    private Player Player1, Player2, Player3, Player4;
    private Pack P1Chars, P2Chars, P3Chars, P4Chars;
    private Pack P1Tiles, P2Tiles, P3Tiles, P4Tiles;
    private Pack Bag = new Pack();
    private ColorPlayer thisColor;
    private Mosaics greenMosaic, redMosaic, yellowMosaic;
    private boolean oneToMillion;
    private int cover;
    private int score1,score2,score3,score4;
    private int[] sphinxCounter={0,0,0,0};
    private int[] caryatidCounter={0,0,0,0};


    //INTERACTION

    /**
     * <b>constructor</b>: Constructs a new Controller and sets the game as
     * eligible to start .<br />
     *
     * <b>postcondition</b>: constructs a new Controller,with new 4 players
     * <p>
     * initialize some int or boolean variables.So,is responsible for creating a new game and
     * initializing it.
     */
    public Controller() throws IOException {
        Player1 = new Player("Manos", ColorPlayer.RED);
        Player2 = new Player("Eleni", ColorPlayer.YELLOW);
        Player3 = new Player("Giannis", ColorPlayer.BLACK);
        Player4 = new Player("Pinelopi", ColorPlayer.BLUE);
        P1Chars = new Pack();
        P2Chars = new Pack();
        P3Chars = new Pack();
        P4Chars = new Pack();
        P1Tiles = new Pack();
        P2Tiles = new Pack();
        P3Tiles = new Pack();
        P4Tiles = new Pack();
        //characters
        archaeologist=new Archaeologist("Archaelogist", ImageIO.read(new File("src\\images_2020\\archaeologist.png")));
        assistant=new Assistant("Assistant", ImageIO.read(new File("src\\images_2020\\assistant.png")));
        digger=new Digger("Digger", ImageIO.read(new File("src\\images_2020\\digger.png")));
        professor=new Professor("Proffesor",ImageIO.read(new File("src\\images_2020\\professor.png")));

        score1=0;
        score2=0;
        score3=0;
        score4=0;
        colors=new ColorPlayer[]{Player1.getColor(),Player2.getColor(),Player3.getColor(),Player4.getColor()};
        cover = 0;
        oneToMillion = false;
    }

    //FOR PLAYERS

    /**
     * <b>Accessors:</b> returns the specific player
     * <b>Postcondition:</b> the specific player has been returned
     * @return Player1 or Player2 or Player3 or Player4
     */
    public Player Player1(){
        return Player1;
    }

    public Player Player2(){
        return Player2;
    }

    public Player Player3(){
        return Player3;
    }

    public Player Player4(){
        return Player4;
    }


    //FOR BOARD
    /**
     * <b>Accessor:</b> returns the board (pack)
     * <b>Postcondition:</b> the board (pack) has been returned
     * @return
     */
    public Board getBoard(){ return board;}

    //FOR COLOR
    /**
     * <b>Transformer:</b> sets the color that has turn to play
     * <b>Postcondition:</b> the color that has turn to play has been set
     * @param thisColor
     */
    public void setThisColor(ColorPlayer thisColor){
        this.thisColor=thisColor;
    }

    /**
     * <b>Accessor:</b> returns the current color
     * <b>Postcondition:</b> the current color has been returned
     * @return thisColor
     */
    public ColorPlayer getThisColor(){return thisColor;}


    //FOR HAND TILES
    /**
     * <b>Accessors:</b> returns the tiles(pack) of the specific player
     * <b>Postcondition:</b> the the tiles(pack) of the specific player has been returned
     * @return P1Tiles or P2Tiles or P3Tiles or P4Tiles
     */
    public Pack getP1Tiles(){ return P1Tiles; }

    public Pack getP2Tiles(){ return P2Tiles; }

    public Pack getP3Tiles(){ return P3Tiles; }

    public Pack getP4Tiles(){ return P4Tiles; }

    /**
     * <b>Accessors:</b> depending on the color returns the tiles(pack) of the specific player
     * <b>Postcondition:</b> the the tiles(pack) of the specific player (depending on the color) has been returned
     * @param color
     * @return P1Tiles or P2Tiles or P3Tiles or P4Tiles
     */
    public Pack returnTiles(ColorPlayer color){
        if(color==ColorPlayer.RED){
            return getP1Tiles();
        }else if(color==ColorPlayer.YELLOW){
            return getP2Tiles();
        }else if(color==ColorPlayer.BLACK){
            return getP3Tiles();
        }else{
            return getP4Tiles();
        }
    }

    //FOR HAND CHARS
    /**
     * <b>Accessors:</b> returns the chars(pack) of the specific player
     * <b>Postcondition:</b> the the chars(pack) of the specific player has been returned
     * @return P1Chars or P2Chars or P3Chars or P4Chars
     */
    public Pack getP1Chars(){ return P1Chars; }

    public Pack getP2Chars(){ return P2Chars; }

    public Pack getP3Chars(){ return P3Chars; }

    public Pack getP4Chars(){ return P4Chars; }

    /**
     * <b>Accessors:</b> depending on the color returns the chars(pack) of the specific player
     * <b>Postcondition:</b> the the chars(pack) of the specific player (depending on the color) has been returned
     * @return P1Chars or P2Chars or P3Chars or P4Chars
     */
    public Pack returnChars(){
        if(seeTurn()==ColorPlayer.RED){
            return getP1Chars();
        }else if(seeTurn()==ColorPlayer.YELLOW){
            return getP2Chars();
        }else if(seeTurn()==ColorPlayer.BLACK){
            return getP3Chars();
        }else{
            return getP4Chars();
        }
    }

    //FOR SCORE
    /**
     * <b>Accessors:</b> returns the score of the specific player
     * <b>Postcondition:</b> the the score of the specific player has been returned
     * @return score1 or score2 or score3 or score4
     */
    public int getScore1() { return score1; }

    public int getScore2() {return score2; }

    public int getScore3() {
        return score3;
    }

    public int getScore4() {
        return score4;
    }

    /**
     * <b>Transformer:</b> gets the score of the specific player
     * <b>Postcondition:</b> the the score of the specific player has been set
     * @param score1 or score2 or score3 or score4
     */
    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public void setScore4(int score4) {
        this.score4 = score4;
    }

    /**
     * <b>Accessors:</b> depending on the color returns the score of the specific player
     * <b>Postcondition:</b> the score of the specific player (depending on the color) has been returned
     * @param color
     * @return
     */
    public int score(ColorPlayer color){
        if(color==ColorPlayer.RED){
            return getScore1();
        }else if(color==ColorPlayer.YELLOW){
            return getScore2();
        }else if(color==ColorPlayer.BLACK){
            return getScore3();
        }else{
            return getScore4();
        }
    }


    /**
     * <b>Accessors:</b> returns the specific character
     * <b>Postcondition:</b> the specific character has been returned
     * @return archaeologist or assistant or digger or professor
     */
    public Archaeologist getArchaeologist() {
        return archaeologist;
    }

    public Assistant getAssistant() {
        return assistant;
    }

    public Digger getDigger() {
        return digger;
    }

    public Professor getProfessor() {
        return professor;
    }

    //FOR MOSAICS

    /**
     * <b>Accessors:</b> returns the specific mosaic (tile)
     * <b>Postcondition:</b> the specific mosaic (tile) has been returned
     * @return greenMosaic or redMosaic or yellowMosaic
     */
    public Mosaics getGreenMosaic() {
        return greenMosaic;
    }

    public Mosaics getRedMosaic() {
        return redMosaic;
    }

    public Mosaics getYellowMosaic() {
        return yellowMosaic;
    }

    //METHOD TO CALCULATE SCORE OF STATUES

    /**
     * <b>Transformer:</b> method to calculate the statues score of every player depending on their score
     * <b>Postcondition:</b> new statues score of the players has been set
     * @param maxi
     * @param mini
     * @param arr
     */
    public void equalValues(int maxi,int mini,int arr[]){
        if(mini==maxi){
            setScore1(getScore1());
            setScore2(getScore2());
            setScore3(getScore3());
            setScore4(getScore4());
        }else {
            for (int i = 0; i < arr.length; i++) {
                if (maxi == arr[i]) {
                    if (i == 0) {
                        setScore1(getScore1() + 6);
                    } else if (i == 1) {
                        setScore2(getScore2() + 6);
                    } else if (i == 2) {
                        setScore3(getScore3() + 6);
                    } else {
                        setScore4(getScore4() + 6);
                    }
                } else if (mini == arr[i]) {
                    if (i == 0) {
                        setScore1(getScore1());
                    } else if (i == 1) {
                        setScore2(getScore2());
                    } else if (i == 2) {
                        setScore3(getScore3());
                    } else {
                        setScore4(getScore4());
                    }
                } else if (arr[i] > mini && arr[i] < maxi) {
                    if (i == 0) {
                        setScore1(getScore1() + 3);
                    } else if (i == 1) {
                        setScore2(getScore2() + 3);
                    } else if (i == 2) {
                        setScore3(getScore3() + 3);
                    } else {
                        setScore4(getScore4() + 3);
                    }
                }
            }
        }
    }

    //One to one million

    /**
     * <b>Transformer:</b> sets the boolean value of oneToMillion when that problem occurs
     * <b>Postcondition:</b> the boolean value of oneToMillion when that problem occurs has been set
     * @param oneToMillion
     */
    public void setOneToMillion(boolean oneToMillion) {
        this.oneToMillion = oneToMillion;
    }

    /**
     * <b>Accessor:</b> returns the boolean value of oneToMillion when that problem occurs
     * <b>Postcondition:</b> the boolean value of oneToMillion when that problem occurs has been returned
     * @return
     */
    public boolean isOneToMillion() {
        return oneToMillion;
    }

    //BEFORE THE GAME STARTS

    /**
     * <b>Transformer:</b> Puts the characters in the pack of every player
     * <b>postcondition:</b> The characters have been successfully put in the packs
     */
    public void initializeCharacters() throws IOException {
        //CREATE CHARACTERS

        //NOW WE PUT THE CHARACTERS IN EVERY PLAYER
        //For Player 1
        P1Chars.addCharacter(archaeologist);
        P1Chars.addCharacter(assistant);
        P1Chars.addCharacter(digger);
        P1Chars.addCharacter(professor);

        //For Player 2
        P2Chars.addCharacter(archaeologist);
        P2Chars.addCharacter(assistant);
        P2Chars.addCharacter(digger);
        P2Chars.addCharacter(professor);

        //For Player 3
        P3Chars.addCharacter(archaeologist);
        P3Chars.addCharacter(assistant);
        P3Chars.addCharacter(digger);
        P3Chars.addCharacter(professor);

        //For Player 4
        P4Chars.addCharacter(archaeologist);
        P4Chars.addCharacter(assistant);
        P4Chars.addCharacter(digger);
        P4Chars.addCharacter(professor);

    }


    /**
     * <b>Transformer:</b> Initializes the tiles inside the bag
     * <b>postcondition:</b> The tiles inside the bag has been initialized
     */
    public void initializeBag() throws IOException {
        //CREATE ALL THE CARDS
        //amphores:
        Amphores blueAmphores=new Amphores(ColorAmphores.BLUE, ImageIO.read(new File("src\\images_2020\\amphora_blue.png")),"Amphoreas");
        Amphores brownAmphores=new Amphores(ColorAmphores.BROWN, ImageIO.read(new File("src\\images_2020\\amphora_brown.png")),"Amphoreas");
        Amphores greenAmphores=new Amphores(ColorAmphores.GREEN, ImageIO.read(new File("src\\images_2020\\amphora_green.png")),"Amphoreas");
        Amphores purpleAmphores=new Amphores(ColorAmphores.PURPLE, ImageIO.read(new File("src\\images_2020\\amphora_purple.png")),"Amphoreas");
        Amphores redAmphores=new Amphores(ColorAmphores.RED, ImageIO.read(new File("src\\images_2020\\amphora_red.png")),"Amphoreas");
        Amphores yellowAmphores=new Amphores(ColorAmphores.YELLOW, ImageIO.read(new File("src\\images_2020\\amphora_yellow.png")),"Amphoreas");

        //mosaics:
        greenMosaic=new Mosaics(ColorMosaics.GREEN,ImageIO.read(new File("src\\images_2020\\mosaic_green.png")),"Mosaic");
        redMosaic=new Mosaics(ColorMosaics.RED,ImageIO.read(new File("src\\images_2020\\mosaic_red.png")),"Mosaic");
        yellowMosaic=new Mosaics(ColorMosaics.YELLOW,ImageIO.read(new File("src\\images_2020\\mosaic_yellow.png")),"Mosaic");

        //skeletons
        Skeletons skeleton_big_bottom=new Skeletons("Skeleton Big Bottom",ImageIO.read(new File("src\\images_2020\\skeleton_big_bottom.png")),true,false,false,true);
        Skeletons skeleton_big_top=new Skeletons("Skeleton Big Top",ImageIO.read(new File("src\\images_2020\\skeleton_big_top.png")),true,false,true,false);
        Skeletons skeleton_small_bottom=new Skeletons("Skeleton Small Bottom",ImageIO.read(new File("src\\images_2020\\skeleton_small_bottom.png")),false,true,false,true);
        Skeletons skeleton_small_top=new Skeletons("Skeleton Small Top",ImageIO.read(new File("src\\images_2020\\skeleton_small_top.png")),false,true,true,false);

        //statues:
        Caryatids caryatid=new Caryatids("Caryatid",ImageIO.read(new File("src\\images_2020\\caryatid.png")));
        Sphinxes sphinx=new Sphinxes("Sphinx",ImageIO.read(new File("src\\images_2020\\sphinx.png")));

        //landslide
        Landslides landslide=new Landslides("Landslide",ImageIO.read(new File("src\\images_2020\\landslide.png")));


        //NOW WE CREATE OUR BAG THAT CONTAINS ALL THE TILES
        //put amphores first
        for(int i=0; i<30; i++){
            if(i<5){
                Bag.addTile(blueAmphores);
            }else if(i<10){
                Bag.addTile(brownAmphores);
            }else if(i<15){
                Bag.addTile(greenAmphores);
            }else if(i<20){
                Bag.addTile(purpleAmphores);
            }else if(i<25){
                Bag.addTile(redAmphores);
            }else{
                Bag.addTile(yellowAmphores);
            }
        }

        //after put mosaics
        for(int i=0; i<27; i++){
            if(i<9){
                Bag.addTile(greenMosaic);
            }else if(i<18){
                Bag.addTile(redMosaic);
            }else{
                Bag.addTile(yellowMosaic);
            }
        }

        //then put skeletons
        for(int i=0; i<30; i++){
            if(i<10){
                Bag.addTile(skeleton_big_top);
            }else if(i<20){
                Bag.addTile(skeleton_big_bottom);
            }else if(i<25){
                Bag.addTile(skeleton_small_top);
            }else{
                Bag.addTile(skeleton_small_bottom);
            }
        }

        //then put statues
        for(int i=0; i<24; i++){
            if(i<12){
                Bag.addTile(caryatid);
            }else{
                Bag.addTile(sphinx);
            }
        }

        //finally put landslides
        for(int i=0; i<24; i++){
            Bag.addTile(landslide);
        }

        //SHUFFLE THE BAG
        Bag.shuffleTiles();
    }


    /**
     * <b>Accessor: </b> Function to print the elements of the bag
     * <b>postcndition:</b> Elements from the bag has been printed
     */
    /*public void printBag() throws IOException {
        for(int i=0; i<Bag.getListTile().size(); i++){
            Tile tile=Bag.getTiLe(i);
        }
    }*/


    /**
     * <b>Transformer:</b> Searches inside the bag for tiles and put 1 from each location at the board and sets the
     * gameStart=true
     * <b>postcondition:</b> The tiles from the bag has been successfully put at the locations and gameStart
     * has been set
     */
    public void initializeLocations() {
        int intAmph, intSta, intSke, intMos;
        intAmph=intSta=intSke=intMos=0;
        //SET THE LOCATION ON THE BOARD WITH 1 TILE EACH
        for(int i=0; i<131; i++){
            if(Bag.getTiLe(i).getType().equals("Amphoreas") && intAmph==0){
                board.setLocationAmphores(Bag.getTiLe(i));
                Bag.removeTile(i);
                intAmph=1;
            }else if((Bag.getTiLe(i).getType().equals("Caryatid") || Bag.getTiLe(i).getType().equals("Sphinx"))&& intSta==0){
                board.setLocationStatues(Bag.getTiLe(i));
                Bag.removeTile(i);
                intSta=1;
            }else if((Bag.getTiLe(i).getType().equals("Skeleton Big Bottom") || Bag.getTiLe(i).getType().equals("Skeleton Big Top") || Bag.getTiLe(i).getType().equals("Skeleton Small Bottom") || Bag.getTiLe(i).getType().equals("Skeleton Small Top"))&& intSke==0){
                board.setLocationSkeletons(Bag.getTiLe(i));
                Bag.removeTile(i);
                intSke=1;
            }else if(Bag.getTiLe(i).getType().equals("Mosaic") && intMos==0){
                board.setLocationMosaics(Bag.getTiLe(i));
                Bag.removeTile(i);
                intMos=1;
            }
            if(intAmph==1 && intSta==1 && intSke==1 && intMos==1){
                break;
            }
        }

    }


    /**
     * <b>Transformer:</b> Picking randomly a color that will start first
     * <b>postcondition:</b> The player who starts first has been successfully declared
     */
    public void whoStartsFirst() {
        Random random = new Random();
        setThisColor(colors[random.nextInt(colors.length)]);
    }


    //THE GAME STARTS AND IT CONTINUES UNTIL LOCATION ENTRANCE IS FULL
    /**
     * <b>Accessor</b>:Returns which player has the turn
     * <b>Postcondition:</b> Returns which player has the turn
     * @return which player has the turn (for example RED if Player1 has the turn )
     */
    public ColorPlayer seeTurn() {
        //IF THE COLOR IS RED OR YELLOW OR BLACK OR BLUE RETURN IT IN ORDER TO USE IT PROPERLY
        if(getThisColor()==ColorPlayer.RED){
            return ColorPlayer.RED;
        }else if(getThisColor()==ColorPlayer.YELLOW){
            return ColorPlayer.YELLOW;
        }else if(getThisColor()==ColorPlayer.BLACK){
            return ColorPlayer.BLACK;
        }else {
            return ColorPlayer.BLUE;

        }
    }



    /**
     * <b>Transformer:</b> the player draws 4 tiles from the bag and place them in the specific location and after
     * choose 2 of all the tiles at the locations
     * <b>postcondition:</b> tiles has been successfully drawn and placed at the board and player has been successfully
     * took 2 tiles from the locations
     */
    public void drawTiles(){
        //WE DRAW FOR TILES FROM THE BAG AND PLACE IT ON THE SPECIFIC LOCATIONS ON THE BOARD
        for(int i=0; i<4; i++){
            if(i>Bag.getListTile().size()){
                    setOneToMillion(true);
                    break;
            }else {
                if (Bag.getTiLe(i).getType().equals("Amphoreas")) {
                    board.setLocationAmphores(Bag.getTiLe(i));
                } else if ((Bag.getTiLe(i).getType().equals("Caryatid") || Bag.getTiLe(i).getType().equals("Sphinx"))) {
                    board.setLocationStatues(Bag.getTiLe(i));
                } else if ((Bag.getTiLe(i).getType().equals("Skeleton Big Bottom") || Bag.getTiLe(i).getType().equals("Skeleton Big Top") || Bag.getTiLe(i).getType().equals("Skeleton Small Bottom") || Bag.getTiLe(i).getType().equals("Skeleton Small Top"))) {
                    board.setLocationSkeletons(Bag.getTiLe(i));
                } else if (Bag.getTiLe(i).getType().equals("Mosaic")) {
                    board.setLocationMosaics(Bag.getTiLe(i));
                } else if (Bag.getTiLe(i).getType().equals("Landslide")) {
                    board.setLocationEntrance(Bag.getTiLe(i));
                    tileIsLandslide();
                }
            }
        }
        Bag.removeTile(0);
        Bag.removeTile(1);
        Bag.removeTile(2);
        Bag.removeTile(3);
    }


    /**
     * <b>Transformer:</b> After a button tile is clicked the hand of the player has been updated
     * <b>postcondition:</b> the hand of the player has been successfully updated
     * @param tile
     */
    public void upgradeHand(Tile tile){
        //DEPENDING ON THE COLOR WE ADD THE TILE WHICH HAS BEEN CLICKED TO THE SPECIFIC PACK
        if(getThisColor()==ColorPlayer.RED){
            P1Tiles.addTile(tile);
        }else if(getThisColor()==ColorPlayer.YELLOW){
            P2Tiles.addTile(tile);
        }else if(getThisColor()==ColorPlayer.BLACK) {
            P3Tiles.addTile(tile);
        }else{
            P4Tiles.addTile(tile);
        }
    }


    //for entrance
    /**
     * <b>Transformer:</b> if the tile is landslide cover 1 of the 16 boxes at locationEntrance and also increase cover
     * by 1 (cover++)
     * <b>postcondition:</b> a landslide cover one box and cover has increased by 1
     */
    public void tileIsLandslide() {
        cover++;
    }


    /**
     * <b>Transformer:</b> the player uses one of his characters ability and after this character is erased
     * <b>postcondition:</b> an ability has been used and the character has been erased
     */
    public void upgradeCharacters(ColorPlayer color,String job){
        //REMOVE THE CHARACTER FROM THE PLAYER DEPENDING ON THE "JOB"
        if(color==ColorPlayer.RED){
            if(job.equals("assistant"))
                P1Chars.removeCharacter(assistant);
            else if(job.equals("archaeologist"))
                P1Chars.removeCharacter(archaeologist);
            else if(job.equals("digger"))
                P1Chars.removeCharacter(digger);
            else
                P1Chars.removeCharacter(professor);
        }else if(color==ColorPlayer.YELLOW){
            if(job.equals("assistant"))
                P2Chars.removeCharacter(assistant);
            else if(job.equals("archaeologist"))
                P2Chars.removeCharacter(archaeologist);
            else if(job.equals("digger"))
                P2Chars.removeCharacter(digger);
            else
                P2Chars.removeCharacter(professor);
        }else if(color==ColorPlayer.BLACK){
            if(job.equals("assistant"))
                P3Chars.removeCharacter(assistant);
            else if(job.equals("archaeologist"))
                P3Chars.removeCharacter(archaeologist);
            else if(job.equals("digger"))
                P3Chars.removeCharacter(digger);
            else
                P3Chars.removeCharacter(professor);
        }else{
            if(job.equals("assistant"))
                P4Chars.removeCharacter(assistant);
            else if(job.equals("archaeologist"))
                P4Chars.removeCharacter(archaeologist);
            else if(job.equals("digger"))
                P4Chars.removeCharacter(digger);
            else
                P4Chars.removeCharacter(professor);
        }
    }


    /**
     * <b>Transformer:</b> the turn of the player has finished and the it plays the next color (RED,YELLOW,BLACK,BLUE)
     * <b>postcondition:</b> endTurn has increased by one so the it is the next Player turn
     */
    public void endTurn(){
        //GO TO THE NEXT COLOR AFTER CALLING END TURN
        if(seeTurn()==ColorPlayer.RED){
            setThisColor(ColorPlayer.YELLOW);
        }else if(seeTurn()==ColorPlayer.YELLOW){
            setThisColor(ColorPlayer.BLACK);
        }else if(seeTurn()==ColorPlayer.BLACK){
            setThisColor(ColorPlayer.BLUE);
        }else{
            setThisColor(ColorPlayer.RED);
        }
    }


    //AFTER THE GAME ENDS

    /**
     *<b>Transformer:</b> calculates the score of every player based on his tiles
     *<b>postcondition:</b> the score of every player has been successfully calculated
     * @param color
     */
    public void setScore(ColorPlayer color) {
        //variable that stores the score of the specific color Player
        int scoring=score(color);

        //FOR MOSAIC
        ArrayList<Tile>[] quads=new ArrayList[6];
        for(int o=0; o<6; o++){
           quads[o]=new ArrayList<>();
        }
        ArrayList<Tile> remains= new ArrayList<>();
        ArrayList<Tile> greenMosaics = new ArrayList<>();
        ArrayList<Tile> redMosaics = new ArrayList<>();
        ArrayList<Tile> yellowMosaics = new ArrayList<>();


        //FOR AMPHORES
        int turns[] = new int[30];
        int truth=0;
        ArrayList<Tile> Amphores = new ArrayList<>();
        ArrayList<Tile> curr = new ArrayList<>();
        ArrayList<Tile> blueAmph=new ArrayList<>();
        ArrayList<Tile> brownAmph=new ArrayList<>();
        ArrayList<Tile> purpleAmph=new ArrayList<>();
        ArrayList<Tile> greenAmph=new ArrayList<>();
        ArrayList<Tile> redAmph=new ArrayList<>();
        ArrayList<Tile> yellowAmph=new ArrayList<>();


        //FOR STATUES
        int caryatid=0;
        int sphinx=0;

        //FOR SKELETONS
        ArrayList<Tile> BigSkeletons = new ArrayList<>();
        ArrayList<Tile> SmallSkeletons = new ArrayList<>();
        ArrayList<Tile> BigTop = new ArrayList<>();
        ArrayList<Tile> BigBot = new ArrayList<>();
        ArrayList<Tile> SmallTop = new ArrayList<>();
        ArrayList<Tile> SmallBot = new ArrayList<>();
        int Bigs=0;
        int Smalls=0;


        //FILL THE ARRAY LISTS FROM THE HAND OF THE PLAYER DEPENDING ON THE TYPE OF EVERY TILE
        for (int i = 0; i < returnTiles(color).getListTile().size(); i++) {
            //IF IT IS AMPHOREAS
            if (returnTiles(color).getTiLe(i).getType().equals("Amphoreas")) {
                if (returnTiles(color).getTiLe(i).toString().equals("Amphoreas BLUE")) {
                    blueAmph.add(returnTiles(color).getTiLe(i));
                }else if (returnTiles(color).getTiLe(i).toString().equals("Amphoreas GREEN")) {
                    greenAmph.add(returnTiles(color).getTiLe(i));
                }else if (returnTiles(color).getTiLe(i).toString().equals("Amphoreas RED")) {
                    redAmph.add(returnTiles(color).getTiLe(i));
                }else if (returnTiles(color).getTiLe(i).toString().equals("Amphoreas BROWN")) {
                    brownAmph.add(returnTiles(color).getTiLe(i));
                }else if (returnTiles(color).getTiLe(i).toString().equals("Amphoreas YELLOW")) {
                    yellowAmph.add(returnTiles(color).getTiLe(i));
                }else {
                    purpleAmph.add(returnTiles(color).getTiLe(i));
                }
                //IF IT IS MOSAIC
            }else if (returnTiles(color).getTiLe(i).getType().equals("Mosaic")) {
                if (returnTiles(color).getTiLe(i).toString().equals("Mosaic GREEN")) {
                    greenMosaics.add(returnTiles(color).getTiLe(i));
                } else if (returnTiles(color).getTiLe(i).toString().equals("Mosaic RED")) {
                    redMosaics.add(returnTiles(color).getTiLe(i));
                } else if (returnTiles(color).getTiLe(i).toString().equals("Mosaic YELLOW")) {
                    yellowMosaics.add(returnTiles(color).getTiLe(i));
                }
                //IF IT IS A STATUE JUST INCREASE THE COUNTER
            }else if (returnTiles(color).getTiLe(i).getType().equals("Sphinx") || returnTiles(color).getTiLe(i).getType().equals("Caryatid")){
                if(returnTiles(color).getTiLe(i).toString().equals("Caryatid")) {
                    caryatid++;
                }else if(returnTiles(color).getTiLe(i).toString().equals("Sphinx")) {
                    sphinx++;
                }
            }else {
                    //IF IT IS SKELETON
                    if (returnTiles(color).getTiLe(i).getType().equals("Skeleton Big Bottom")) {
                        BigBot.add(returnTiles(color).getTiLe(i));
                    }else if (returnTiles(color).getTiLe(i).getType().equals("Skeleton Big Top")) {
                        BigTop.add(returnTiles(color).getTiLe(i));
                    }else if (returnTiles(color).getTiLe(i).getType().equals("Skeleton Small Top")) {
                        SmallTop.add(returnTiles(color).getTiLe(i));
                    }else {
                        SmallBot.add(returnTiles(color).getTiLe(i));
                    }
                }
        }


        //NOW THAT WE HAVE FILLED OUR ARRAYS AND COUNTERS JUST CALCULATE THE SCORE

        //firstly make statue counter of the player equal to caryatid (counter) and sphinx (counter)
        if(color==ColorPlayer.RED){
            sphinxCounter[0]=sphinx;
            caryatidCounter[0]=caryatid;
        }else if(color==ColorPlayer.YELLOW){
            sphinxCounter[1]=sphinx;
            caryatidCounter[1]=caryatid;
        }else if(color==ColorPlayer.BLACK){
            sphinxCounter[2]=sphinx;
            caryatidCounter[2]=caryatid;
        }else{
            sphinxCounter[3]=sphinx;
            caryatidCounter[3]=caryatid;
        }


        //after mosaics. For every color if there are more than 4 just calculate score and add the remains to the arrayList
        if(greenMosaics.size()>=4){
            scoring=scoring+4;
            for(int j=0; j<greenMosaics.size(); j++){
                if(j>=4)
                    remains.add(greenMosaics.get(j));
            }
        }else{
            for(int j=0; j<greenMosaics.size(); j++){
                remains.add(greenMosaics.get(j));
            }
        }
        if(redMosaics.size()>=4){
            scoring=scoring+4;
            for(int j=0; j<redMosaics.size(); j++){
                if(j>=4)
                    remains.add(redMosaics.get(j));
            }
        }else{
            for(int j=0; j<redMosaics.size(); j++){
                remains.add(redMosaics.get(j));
            }
        }
        if(yellowMosaics.size()>=4){
            scoring=scoring+4;
            for(int j=0; j<yellowMosaics.size(); j++){
                if(j>=4)
                    remains.add(yellowMosaics.get(j));
            }
        }else{
            for(int j=0; j<yellowMosaics.size(); j++){
                remains.add(yellowMosaics.get(j));
            }
        }

        //For the remains make four so as to create a full mosaic
        int l=0;
        while(l<remains.size()){
            if(l<4){
                quads[0].add(remains.get(l));
            }else if(l<8){
                quads[1].add(remains.get(l));
            }else if(l<12){
                quads[2].add(remains.get(l));
            }else if(l<16){
                quads[3].add(remains.get(l));
            }else if(l<20){
                quads[4].add(remains.get(l));
            }else {
                quads[5].add(remains.get(l));
            }
            l++;
        }

        //now if there are more than 2 same colors in a full mosaic calculate score+2 or nothing
        for(int m=0; m<6; m++){
            if(quads[m].size()==4){
                if(Collections.frequency(quads[m],getGreenMosaic())==4 || Collections.frequency(quads[m],getRedMosaic())==4 || Collections.frequency(quads[m],getYellowMosaic())==4){
                    scoring=scoring+4;
                }else if(Collections.frequency(quads[m],getGreenMosaic())>=2 || Collections.frequency(quads[m],getRedMosaic())>=2 || Collections.frequency(quads[m],getYellowMosaic())>=2){
                    scoring=scoring+2;
                }
            }
        }
        //System.out.println("UNTIL MOSAICS:"+scoring);


        //secondly make pairs of BigSkeletons first and then Small Skeletons
        int i;
        for(i=0; i< BigBot.size()+BigTop.size(); i++){

            if(BigBot.size()!=0) {
                if(i<BigBot.size()) {
                    BigSkeletons.add(BigBot.get(i));
                }
            }
            if(BigTop.size()!=0){
                if(i<BigTop.size())
                    BigSkeletons.add(BigTop.get(i));
            }
        }

        for (i = 0; i <SmallBot.size()+SmallTop.size(); i++){
            if(SmallBot.size()!=0) {
                if(i<SmallBot.size())
                    SmallSkeletons.add(SmallBot.get(i));
            }
            if(SmallTop.size()!=0) {
                if(i<SmallTop.size())
                    SmallSkeletons.add(SmallTop.get(i));
            }
        }
        i=0;

        //After this count the Big skeleton and Small skeleton pairs
        while(i<BigSkeletons.size()-1){
            if(BigSkeletons.get(i).getType().equals("Skeleton Big Bottom") && BigSkeletons.get(i+1).getType().equals("Skeleton Big Top")){
                Bigs++;
            }
            i+=2;
        }
        i=0;
        while(i<SmallSkeletons.size()-1){
            if(SmallSkeletons.get(i).getType().equals("Skeleton Small Bottom") && SmallSkeletons.get(i+1).getType().equals("Skeleton Small Top")){
                Smalls++;
            }
            i+=2;
        }
        //System.out.println("Bigs is "+Bigs+" and small is "+Smalls);

        //based on the counters calculate the score of the skeletons
        if(Smalls>=4 && Bigs>=8){
            scoring=scoring+24;
            Smalls=Smalls-4;
            Bigs=Bigs-8;
        }else if(Smalls>=3 && Bigs>=6){
            scoring=scoring+18;
            Smalls=Smalls-3;
            Bigs=Bigs-6;
        }else if(Smalls>=2 && Bigs>=4){
            scoring=scoring+12;
            Smalls=Smalls-2;
            Bigs=Bigs-4;
        }else if(Smalls>=1 && Bigs>=2){
            scoring=scoring+6;
            Smalls=Smalls-1;
            Bigs=Bigs-2;
        }
        scoring=scoring+Smalls+Bigs;
        //System.out.println("UNTIL SKELETONS:"+scoring);


        //now for amphores just add in an arraylist first blues then red,green,purple,brown,yellow... until all sum of the sizes
        for (i = 0; i <blueAmph.size()+redAmph.size()+greenAmph.size()+purpleAmph.size()+brownAmph.size()+yellowAmph.size(); i++) {
            if (blueAmph.size() != 0) {
                if (i < blueAmph.size())
                    Amphores.add(blueAmph.get(i));
            }if (redAmph.size() != 0) {
                if (i < redAmph.size())
                    Amphores.add(redAmph.get(i));
            }if (greenAmph.size() != 0) {
                if (i < greenAmph.size())
                    Amphores.add(greenAmph.get(i));
            }if (purpleAmph.size()!=0) {
                if (i < purpleAmph.size())
                    Amphores.add(purpleAmph.get(i));
            }if(brownAmph.size() != 0){
                 if(i<brownAmph.size())
                     Amphores.add(brownAmph.get(i));
            }if(yellowAmph.size() != 0){
                if(i<yellowAmph.size())
                    Amphores.add(yellowAmph.get(i));
            }
        }

        //now we need to divide all the different amphores until we find an amphora with the same color as before
        //for this we need another arraylist to store all the previous amphores and compare all the amphores colors with the current
        //if there is an amphora with the same color as the current just start counting from the start
        int j=0;
        int uol=0;
        int uol2=0;
        i=0;
        int counter=0;
        turns[counter]=0;
        while( i<Amphores.size()-1){
            curr.add(Amphores.get(i));
            turns[counter]++;
            while(j< curr.size()){
                if (Amphores.get(i+1).toString().equals(curr.get(j).toString())){
                    uol++;
                    counter++;
                    turns[counter]=0;
                    curr.clear();
                }
                j++;
            }
            j=0;
            i++;
        }

        for(i=0; i<30; i++){
            truth++;
            if(uol==i){
                uol2=1;
                turns[i]++;
                break;
            }
        }
        for(i=0; i<30; i++){
            if(uol2==0) {
                truth++;
                if (turns[i] != 0 && turns[i + 1] == 0) {
                    turns[i + 1]++;
                    break;
                }
            }else{
                break;
            }
        }

        //so based of every counter calculate the score
        for(i=0; i<truth; i++){
            if(turns[i]==6)
                scoring=scoring+6;
            else if(turns[i]==5)
                scoring=scoring+4;
            else if(turns[i]==4)
                scoring=scoring+2;
            else if(turns[i]==3)
                scoring=scoring+1;
        }
        //System.out.println("UNTIL AMPHORES:"+scoring);

        //finally store the score to the specific player
        if(color==ColorPlayer.RED)
            setScore1(scoring);
        else if(color==ColorPlayer.YELLOW)
            setScore2(scoring);
        else if(color==ColorPlayer.BLACK)
            setScore3(scoring);
        else
            setScore4(scoring);
    }


    /**
     *<b>Transformer:</b> calculates the score of every player after comparing all the statues they have
     *<b>postcondition:</b> the score of every player has been successfully rechanged
     */
    public void setStatuesScore(){

        int minCar=13;
        int minSph=13;
        int maxCar=-1;
        int maxSph=-1;

        //find the min and max of both of statues in every player
        for(int i=0; i<4; i++) {
            //System.out.println("Caryatids " + caryatidCounter[i] + " Sphinx " + sphinxCounter[i]);
            if (minCar > caryatidCounter[i]) {
                minCar = caryatidCounter[i];
            }
            if (minSph > sphinxCounter[i]) {
                minSph = sphinxCounter[i];
            }
            if (maxCar < caryatidCounter[i]) {
                maxCar = caryatidCounter[i];
            }
            if (maxSph < sphinxCounter[i]){
                maxSph = sphinxCounter[i];
            }
        }
        //pass them to the function

        //calculate score of caryatids
        equalValues(maxCar,minCar,caryatidCounter);

        //calculate score of sphinx
        equalValues(maxSph,minSph,sphinxCounter);
    }


    /**
     * <b>Accessor: </b> sets and returns the winner's name and the other names based on the score
     * <b>postcondition: </b> the winner's name and the other names  has been set and returned.
     * @param arr
     * @return names
     */
    public String[] getWinner(int[] arr) {
        String[] names=new String[4];
        int red=0;
        int yellow=0;
        int black=0;
        int blue=0;
        for(int j=0; j<4; j++){
            names[j]= "";
        }

        //based on the score number the names
        for(int i=0; i<4; i++){
            if(arr[i]==getScore1() && red==0) {
                names[i]=Player1().getName();
                red=1;
            }else if(arr[i]==getScore2() && yellow==0) {
                names[i]=Player2().getName();
                yellow=1;
            }else if(arr[i]==getScore3() && black==0) {
                names[i]=Player3().getName();
                black=1;
            }else if(arr[i]==getScore4() && blue==0) {
                names[i]=Player4().getName();
                blue=1;
            }
        }
        return names;
    }

    /**
     * <b>Accessor: </b> sets and returns the score table with declining order
     * <b>postcondition: </b> the score table with declining order  has been set and returned.
     * @return score table
     */
    public int[] getScoreWinner(){
        int[] arr= {getScore1(),getScore2(),getScore3(),getScore4()};
        int temp;

        //just an algorithm to return an array with the scoreswith declining order
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * <b>Accessor: </b> sets and returns the winner's color and the other colors based on the score
     * <b>postcondition: </b> the winner's color and the other colors has been set and returned.
     * @param arr
     * @return
     */
    public String[] getColors(int[] arr){
        String[] colors=new String[4];
        int red=0;
        int yellow=0;
        int black=0;
        int blue=0;
        for(int j=0; j<4; j++){
            colors[j]= "";
        }
        //based on the score number the colors
        for(int i=0; i<4; i++){
            if(arr[i]==getScore1() && red==0) {
                colors[i]=("red");
                red=1;
            }else if(arr[i]==getScore2() && yellow==0) {
                colors[i]=("yellow");
                yellow=1;
            }else if(arr[i]==getScore3() && black==0) {
                colors[i]=("black");
                black=1;
            }else if(arr[i]==getScore4() && blue==0) {
                colors[i]=("blue");
                blue=1;
            }
        }
        return colors;

    }
}
