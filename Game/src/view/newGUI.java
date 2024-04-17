package view;

import controller.Controller;
import model.Pack.Pack;
import model.Player.ColorPlayer;
import model.Tile.Tile;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class newGUI{

    //THIS IS OUR GUI:
    //first we initialize our attributes

    //interaction with the controller
    private Controller controller;

    //The JFrame
    private JFrame frame;

    //The choice panel
    private JPanel paneOne;
    private JPanel paneTwo;
    private JPanel paneThree;
    private JPanel paneFour;
    private JPanel currentPane;

    //The displaying tiles panel
    private JPanel tilesOne;
    private JPanel tilesTwo;
    private JPanel tilesThree;
    private JPanel tilesFour;
    private JPanel currentTiles;

    //The board panel
    private JPanel board;

    //FOR EVERY PLAYER THERE ARE ICONS, LABELS AND BUTTONS
    //firstly buttons
    private JButton[] P1Chars;
    private JButton[] P2Chars;
    private JButton[] P3Chars;
    private JButton[] P4Chars;
    private JButton draw;
    private JButton end;
    private JButton[][] mosaicsButtons=new JButton[4][4];
    private JButton[][] statuesButtons=new JButton[4][4];
    private JButton[][] amphoresButtons=new JButton[4][4];
    private JButton[][] skeletonsButtons=new JButton[4][4];

    //after labels
    private JLabel myLabel;
    private JLabel myTiles;
    private JLabel tile;

    //finally icons
    private ImageIcon archaeologist;
    private ImageIcon assistant;
    private ImageIcon digger;
    private ImageIcon professor;
    private Icon icon;

    //dont forget gbc
    private GridBagConstraints gbc=new GridBagConstraints();


    //FOR THE BOARD WE HAVE THE IMAGE OF COURSE AND PANELS
    private BufferedImage bg;
    private JPanel locationMosaics;
    private JPanel locationAmphores;
    private JPanel locationStatues;
    private JPanel locationSkeletons;
    private JPanel locationEntrance;

    //FOR END TURN WE HAVE 4 DIFFERENT COLOR PANELS
    private  JPanel redPanel;
    private JPanel yellowPanel;
    private JPanel blackPanel;
    private JPanel bluePanel;

    //WE HAVE ALSO 4 DIFFERENT COLORS FOR TILE HOLDERS
    private JPanel redTiles;
    private JPanel yellowTiles;
    private JPanel blackTiles;
    private JPanel blueTiles;

    //String
    private int which;

    //Ints
    private int check;
    private int toInitialize;
    private int toEnd;
    private int cover;
    private int itsProf;

    //Current color
    private ColorPlayer currentColor;

    //interact with end
    private int givePermission;


    /**
     *WE ALSO HAVE HELPFUL FUNCTIONS TO CREATE NICE COMPONENTS
     */
    //SET THE LOCATION THERE

    /**
     * <b>Transformer:</b> sets the location and the size of a panel
     * <b>Postcondition:</b> sets the location and the size has been set
     * @param location
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void Square(JPanel location,int x, int y, int width, int height){
        location.setLayout(new GridLayout(4,4));

        //set location and size
        location.setLocation(x,y);
        location.setSize(width,height);
    }
    //GET THE LOCATION

    /**
     * <b>Accessor:</b> returns the panel that corresponds to a specific board location
     * <b>postcondition:</b> the panel that corresponds to a specific board location has been returned
     * @return
     */
    public JPanel getLocationMosaics(){ return locationMosaics;}
    public JPanel getLocationAmphores(){ return locationAmphores;}
    public JPanel getLocationStatues(){ return locationStatues;}
    public JPanel getLocationSkeletons(){ return locationSkeletons;}
    public JPanel getLocationEntrance(){ return locationEntrance;}

    //GET RESIZED IMAGE

    /**
     * <b>Accessor:</b> returns the resized image that has been passed
     * <b>postcondition:</b> the resized image that has been passed has been returned
     * @param srcImg
     * @param w
     * @param h
     * @return
     */
    public Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    /**
     * <b>Accessor:</b> based of the current color returns the hand of the player
     * <b>postcondition:</b> based of the current color the hand of the player has been returned
     * @return
     */
    public Pack takePack(){
        //returns the current hand
        if(controller.seeTurn()==ColorPlayer.RED) {
            return controller.getP1Tiles();
        }else if(controller.seeTurn()==ColorPlayer.YELLOW){
            return controller.getP2Tiles();
        }else if(controller.seeTurn()==ColorPlayer.BLACK){
            return controller.getP3Tiles();
        }else{
            return controller.getP4Tiles();
        }

    }

    /**
     * <b>Accessor:</b> based of the current color returns the characters of the player
     * <b>postcondition:</b> based of the current color the characters of the player has been returned
     * @return
     */
    public JButton[] takeChars(){
        if(controller.seeTurn()==ColorPlayer.RED) {
            return P1Chars;
        }else if(controller.seeTurn()==ColorPlayer.YELLOW){
            return P2Chars;
        }else if(controller.seeTurn()==ColorPlayer.BLACK){
            return P3Chars;
        }else{
            return P4Chars;
        }

    }

    /**
     * <b>Transformer:</b> switch the jbuttons
     * <b>Postcondition:</b> the jbuttons has been switched
     * @param type
     * @param bol
     */
    public void ableTiles(String type, Boolean bol){
        //DEPENDING OF THE TYPE DISABLE OR ENABLE THE REST OF THE JBUTTONS
        if(type.equals("Mosaic")) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (statuesButtons[i][j] != null)
                        statuesButtons[i][j].setEnabled(bol);
                    if (amphoresButtons[i][j] != null)
                        amphoresButtons[i][j].setEnabled(bol);
                    if (skeletonsButtons[i][j] != null)
                        skeletonsButtons[i][j].setEnabled(bol);
                }
            }
        }else if(type.equals("Amphoreas")){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (mosaicsButtons[i][j] != null)
                        mosaicsButtons[i][j].setEnabled(bol);
                    if (statuesButtons[i][j] != null)
                        statuesButtons[i][j].setEnabled(bol);
                    if (skeletonsButtons[i][j] != null)
                        skeletonsButtons[i][j].setEnabled(bol);
                }
            }
        }else if(type.equals("Statue")){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (mosaicsButtons[i][j] != null)
                        mosaicsButtons[i][j].setEnabled(bol);
                    if (amphoresButtons[i][j] != null)
                        amphoresButtons[i][j].setEnabled(bol);
                    if (skeletonsButtons[i][j] != null)
                        skeletonsButtons[i][j].setEnabled(bol);
                }
            }
        }else if(type.equals("Skeleton")){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (mosaicsButtons[i][j] != null)
                        mosaicsButtons[i][j].setEnabled(bol);
                    if (statuesButtons[i][j] != null)
                        statuesButtons[i][j].setEnabled(bol);
                    if (amphoresButtons[i][j] != null)
                        amphoresButtons[i][j].setEnabled(bol);
                }
            }
            //IF IT IS ALL DISABLE OR ENABLE THEM ALL
        }else if(type.equals("All")){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (mosaicsButtons[i][j] != null)
                        mosaicsButtons[i][j].setEnabled(bol);
                    if (statuesButtons[i][j] != null)
                        statuesButtons[i][j].setEnabled(bol);
                    if (amphoresButtons[i][j] != null)
                        amphoresButtons[i][j].setEnabled(bol);
                    if (skeletonsButtons[i][j] != null)
                        skeletonsButtons[i][j].setEnabled(bol);
                }
            }
        }
    }

    /**
     * <b>Accessor:</b> returns the String of the last tile of the current players pack
     * <b>postcondition:</b> the String of the last tile of the current players pack has been returned
     * @param num
     * @return
     */
    public String lastTile(int num){
        //IF THE HAND HAS NO TILES RETURN ERROR
        if(takePack().getListTile().size()-num==-1)
            return ("ERROR");
        //ELSE RETURN THE LAST TILE STRING
        if(takePack().getTiLe(takePack().getListTile().size()-num).getType().equals("Amphoreas")){
            return ("Amphoreas");
        }else if(takePack().getTiLe(takePack().getListTile().size()-num).getType().equals("Mosaic")){
            return ("Mosaic");
        }else if(takePack().getTiLe(takePack().getListTile().size()-num).getType().equals("Caryatid") || takePack().getTiLe(takePack().getListTile().size()-1).getType().equals("Sphinx")){
            return ("Statue");
        }else{
            return ("Skeleton");
        }
    }

    /**
     * <b>Transformer:</b> disables the buttons of the given type
     * <b>Postcondition:</b> the buttons of the given type has been disabled
     * @param type
     */
    public void falseLocation(String type){
        //BASED ON THE TYPE DISABLE THE JBUTTONS
        if(type.equals("Amphoreas")){
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (amphoresButtons[i][j] != null)
                        amphoresButtons[i][j].setEnabled(false);
        }else if(type.equals("Mosaic")){
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (mosaicsButtons[i][j] != null)
                        mosaicsButtons[i][j].setEnabled(false);
        }else if(type.equals("Statue")){
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (statuesButtons[i][j] != null)
                        statuesButtons[i][j].setEnabled(false);
        }else if(type.equals("Skeleton")){
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    if (skeletonsButtons[i][j] != null)
                        skeletonsButtons[i][j].setEnabled(false);
        }
    }

    /**
     * <b>Transformer:</b> loads the final jpanel that concludes jlabels of the winner the other names and scores
     * <b>Postcondition:</b> the final jpanel has been loaded
     */
    public void endGame(){
        //CALCULATE THE SCORE
        controller.setScore(ColorPlayer.RED);
        controller.setScore(ColorPlayer.YELLOW);
        controller.setScore(ColorPlayer.BLACK);
        controller.setScore(ColorPlayer.BLUE);
        controller.setStatuesScore();

        //PRINT SCORES
        /*System.out.println("Scores");
        System.out.println(controller.getScore1());
        System.out.println(controller.getScore2());
        System.out.println(controller.getScore3());
        System.out.println(controller.getScore4());*/

        //STORE SCORE NAMES AND COLORS OF THE PLAYERS
        int[] arr=controller.getScoreWinner();
        String[] names=controller.getWinner(arr);
        String[] color=controller.getColors(arr);


        //REMOVE ALL THE PANELS AND ADD THE FINAL PANEL
        playSound("src\\sounds\\win.wav");
        playSound("src\\sounds\\claps.wav");
        getFrame().remove(getCurrentPane());
        getFrame().remove(getCurrentTiles());
        getBoard().remove(getLocationAmphores());
        getBoard().remove(getLocationMosaics());
        getBoard().remove(getLocationStatues());
        getBoard().remove(getLocationSkeletons());
        getBoard().remove(getLocationEntrance());

        //PRINT THE NAMES SCORE AND COLORS OF THE PLAYERS
        JPanel endPanel=new JPanel(null);
        endPanel.setBackground(Color.pink);
        JLabel endLabel1=new JLabel();
        if(arr[0]==arr[1]){
            endLabel1.setText("<html><font color=> Winner is: </font> <font color="+color[0]+"> "+names[0]+" ("+arr[0]+")</font> (DRAW) </html>");
        }else {
            endLabel1.setText("<html><font color=> Winner is: </font> <font color=" + color[0] + "> " + names[0] + " (" + arr[0] + ")</font></html>");
        }
        JLabel endLabel2=new JLabel("2."+names[1]+" ("+arr[1]+")"+"                  3."+names[2]+" ("+arr[2]+")"+"                 4."+names[3]+" ("+arr[3]+")");
        JLabel thanks=new JLabel("Thanks for playing!!!");

        endLabel1.setFont(new Font("ROMAN_BASELINE", Font.BOLD, 55));
        endLabel2.setFont(new Font("ROMAN_BASELINE", Font.BOLD, 45));
        thanks.setFont(new Font("Serif",Font.ITALIC,35));
        thanks.setHorizontalAlignment(JLabel.CENTER);

        endPanel.add(endLabel1);
        endPanel.add(endLabel2);
        endPanel.add(thanks);


        Square(endPanel,0,0,1350,740);
        getBoard().add(endPanel);

        getBoard().revalidate();
        getBoard().repaint();
    }

    /**
     * helpful functions end here
     */


    /**
     *OUR CONSTRUCTOR
     * -----------------------------------------------------------------------------------------------
     * <b>constructor</b>: Creates a new Window and initializes some panels <br />
     * <b>postconditions</b>: Creates a new Window and initializes panels
     * starting a new game.
     */
    public newGUI() throws IOException {
        //MAKE THE OPTIONS OF THE CONTROLLER BEFORE GAME STARTS
        controller=new Controller();
        controller.initializeCharacters();
        controller.initializeBag();
        controller.initializeLocations();
        controller.whoStartsFirst();

        //PUT THE TILES AT THE SPECIFIC LOCATION PANELS
        initializeComponents();
        addButtonTile(controller.getBoard().getListLocationMosaics(),controller.getBoard().getListLocationMosaics().size());
        addButtonTile(controller.getBoard().getListLocationStatues(),controller.getBoard().getListLocationStatues().size());
        addButtonTile(controller.getBoard().getListLocationAmphores(),controller.getBoard().getListLocationAmphores().size());
        addButtonTile(controller.getBoard().getListLocationSkeletons(),controller.getBoard().getListLocationSkeletons().size());

        //NOW MAKE AN INSTANCE OF EVERY PANEL
        //board
        boardPanel(new createBoard());
        //tile display
        setTilesOne(new createTilePanel());
        //option display
        setPaneOne(new createOptionPanel());
        addPanelLabels(getPaneOne(),getCurrentColor());

        //setCurrentPane and CurrentTiles for endTurn
        setCurrentPane(getPaneOne());
        setCurrentTiles(getTilesOne());

        for(int i=0; i<4; i++){
            P1Chars[i].setEnabled(false);
            P2Chars[i].setEnabled(false);
            P3Chars[i].setEnabled(false);
            P4Chars[i].setEnabled(false);
        }




        //inside frame
        getFrame().add(getBoard(),"Center");
        getFrame().add(getCurrentTiles(),"South");
        getFrame().add(getPaneOne(),"West");

        //this.getFrame();

        getFrame().setSize(1350, 740);
        getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getFrame().setVisible(true);
    }

    /**
     * <b>transformer(mutative)</b>:initializes some buttons and labels <br />
     * <p><b>Postcondition:</b> initializes some buttons and labels </p>
     */
    public void initializeComponents(){
        //frame
        frame=new JFrame("Amphipolis");
        //choice panels
        paneOne=new JPanel();
        paneTwo=new JPanel();
        paneThree=new JPanel();
        paneFour=new JPanel();
        currentPane=new JPanel();

        //tile panels
        tilesOne=new JPanel();
        tilesTwo=new JPanel();
        tilesThree=new JPanel();
        tilesFour=new JPanel();
        currentTiles=new JPanel();

        //the board
        board=new JPanel();

        //For end turn
        redPanel=new JPanel();
        yellowPanel=new JPanel();
        blackPanel=new JPanel();
        bluePanel=new JPanel();

        redTiles=new JPanel();
        yellowTiles=new JPanel();
        blackTiles=new JPanel();
        blueTiles=new JPanel();


        //LOCATIONS AND INITIALIZATIONS
        locationAmphores=new JPanel();
        locationMosaics=new JPanel();
        locationSkeletons=new JPanel();
        locationEntrance=new JPanel();
        locationStatues=new JPanel();
        Square(locationMosaics,28, 16, 283, 191);
        Square(locationStatues,657,16,283,191);
        Square(locationAmphores,28,442,283,191);
        Square(locationSkeletons,657,442,283,191);
        Square(locationEntrance,344,283,279,191);

        //images
        //Manufacture all the tile images

        //Buttons
        P1Chars=new JButton[4];
        P2Chars=new JButton[4];
        P3Chars=new JButton[4];
        P4Chars=new JButton[4];
        for(int i=0; i<4; i++){
            P1Chars[i]=new JButton();
            P2Chars[i]=new JButton();
            P3Chars[i]=new JButton();
            P4Chars[i]=new JButton();
        }


        //icons
        archaeologist=new ImageIcon("src\\images_2020\\archaeologist.png");
        assistant=new ImageIcon("src\\images_2020\\assistant.png");
        digger=new ImageIcon("src\\images_2020\\digger.png");
        professor=new ImageIcon("src\\images_2020\\professor.png");

        //labels
        myLabel=new JLabel();
        myTiles=new JLabel();

        //ints
        check=0;
        cover=0;
        itsProf=0;
        toInitialize=0;
        setToInitialize(0);
        givePermission=0;

        //setCurrentColor
        currentColor=controller.seeTurn();
        setCurrentColor(currentColor);
        //set the other panels
        //the Option Panel

    }

    /**
     *SETTER AND GETTERS
     */
    //get the frame
    public JFrame getFrame(){return frame;}

    //which tile has been drawn
    public void setWhich(int which){
        this.which=which;
    }
    public int getWhich(){ return which;}

    //check is for how many tiles the player can draw
    public void setCheck(int check){ this.check=check;}
    public int getCheck(){return check;}

    //ToInitialize is used to initialze the rest of the panels when end is pressed
    public void setToInitialize(int toInitialize){this.toInitialize=toInitialize;}
    public int getToInitialize(){return toInitialize;}


    //Current optionPanel and current Tiles
    public void setCurrentPane(JPanel currentPane){this.currentPane=currentPane;}
    public JPanel getCurrentPane(){return currentPane;}
    public void setCurrentTiles(JPanel currentTiles){
        this.currentTiles=currentTiles;
        this.currentTiles.setBackground(Color.LIGHT_GRAY);
        this.currentTiles.setPreferredSize(new Dimension(50,50));
    }
    public JPanel getCurrentTiles(){return currentTiles;}


    //Current color
    public void setCurrentColor(ColorPlayer currentColor){this.currentColor=currentColor;}
    public ColorPlayer getCurrentColor(){return currentColor;}

    //Setter and getters for options of every player color
    public void setRedPanel(JPanel redPanel){this.redPanel=redPanel;}
    public void setYellowPanel(JPanel yellowPanel){this.yellowPanel=yellowPanel;}
    public void setBlackPanel(JPanel blackPanel){this.blackPanel=blackPanel;}
    public void setBluePanel(JPanel bluePanel){this.bluePanel=bluePanel;}

    public JPanel getRedPanel(){return redPanel;}
    public JPanel getYellowPanel(){return yellowPanel;}
    public JPanel getBlackPanel(){return blackPanel;}
    public JPanel getBluePanel(){return bluePanel;}


    ////Setter and getters for tiles of every player color
    public void setRedTiles(JPanel redTiles){this.redTiles=redTiles;}
    public void setYellowTiles(JPanel yellowTiles){this.yellowTiles=yellowTiles;}
    public void setBlackTiles(JPanel blackTiles){this.blackTiles=blackTiles;}
    public void setBlueTiles(JPanel blueTiles){this.blueTiles=blueTiles;}

    public JPanel getRedTiles(){return redTiles;}
    public JPanel getYellowTiles(){return yellowTiles;}
    public JPanel getBlackTiles(){return blackTiles;}
    public JPanel getBlueTiles(){return blueTiles;}

    //when prof is pressed we must do another action when a tile is clicked
    public void setitsProf(int itsProf){this.itsProf=itsProf; }
    public int getitsProf(){return itsProf;}

    //for landslides cover
    public void setCover(int cover){this.cover=cover;}
    public int getCover(){return cover;}

    //for the board
    public void boardPanel(JPanel board){
        this.board=board;
    }
    public JPanel getBoard(){ return board;}


    /**
     * Create the board.
     */

    //create the board adding background and the location panels
    public class createBoard extends JPanel{
        createBoard() throws IOException {
            this.setLayout(null);
            bg= ImageIO.read(new File("src\\images_2020\\background.png"));
            this.add(locationMosaics);
            this.add(locationStatues);
            this.add(locationAmphores);
            this.add(locationSkeletons);
            this.add(locationEntrance);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bg != null) {
                g.drawImage(bg,0, 0, getWidth(), getHeight(), this);
            }
        }
    }


    //add the array to the specific panel

    /**
     * <b>Transformer:</b> Function that transform the tile into button and add it to the specific location
     * <b>postcondition:</b> The tile has transformed successfully to button and added to the specific location
     * @param location
     * @param size
     */
    public void addButtonTile(ArrayList<Tile> location, int size){
        Image img;
        JPanel thisPanel=new JPanel();
        int sizeCounter=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Icon icon;
                if(sizeCounter<size){
                    if(location.get(0).getType()=="Mosaic"){
                        mosaicsButtons[i][j]=new JButton();
                        setWhich(1);
                        mosaicsButtons[i][j].setEnabled(false);
                        mosaicsButtons[i][j].addActionListener(new buttonTileListener(getWhich()));
                        img=location.get(sizeCounter).getTileImage();
                        icon = new ImageIcon(getScaledImage(img, 70, 50));
                        mosaicsButtons[i][j].setIcon(icon);
                        getLocationMosaics().add(mosaicsButtons[i][j]);
                        thisPanel=getLocationMosaics();
                    }else if(location.get(0).getType()=="Caryatid" || location.get(0).getType()=="Sphinx"){
                        statuesButtons[i][j]=new JButton();
                        setWhich(2);
                        statuesButtons[i][j].setEnabled(false);
                        statuesButtons[i][j].addActionListener(new buttonTileListener(getWhich()));
                        img=location.get(sizeCounter).getTileImage();
                        icon = new ImageIcon(getScaledImage(img, 70, 50));
                        statuesButtons[i][j].setIcon(icon);
                        getLocationStatues().add(statuesButtons[i][j]);
                        thisPanel=getLocationStatues();
                    }else if(location.get(0).getType()=="Amphoreas"){
                        amphoresButtons[i][j]=new JButton();
                        setWhich(3);
                        amphoresButtons[i][j].setEnabled(false);
                        amphoresButtons[i][j].addActionListener(new buttonTileListener(getWhich()));
                        img=location.get(sizeCounter).getTileImage();
                        icon = new ImageIcon(getScaledImage(img, 70, 50));
                        amphoresButtons[i][j].setIcon(icon);
                        getLocationAmphores().add(amphoresButtons[i][j]);
                        thisPanel=getLocationAmphores();
                    }else if(location.get(0).getType().equals("Skeleton Big Bottom") || location.get(0).getType().equals("Skeleton Big Top") || location.get(0).getType().equals("Skeleton Small Bottom") || location.get(0).getType().equals("Skeleton Small Top")){
                        setWhich(4);
                        skeletonsButtons[i][j]=new JButton();
                        skeletonsButtons[i][j].setEnabled(false);
                        skeletonsButtons[i][j].addActionListener(new buttonTileListener(getWhich()));
                        img=location.get(sizeCounter).getTileImage();
                        icon = new ImageIcon(getScaledImage(img, 70, 50));
                        skeletonsButtons[i][j].setIcon(icon);
                        getLocationSkeletons().add(skeletonsButtons[i][j]);
                        thisPanel=getLocationSkeletons();
                    }else{
                        JLabel myLabel = new JLabel();
                        img=location.get(sizeCounter).getTileImage();
                        icon = new ImageIcon(getScaledImage(img, 70, 50));
                        myLabel.setIcon(icon);
                        getLocationEntrance().add(myLabel);
                        thisPanel=getLocationEntrance();
                    }

                }else{
                    JLabel label = new JLabel("");
                    thisPanel.add(label);
                }
                sizeCounter++;
            }
        }
    }


    /**
     *Create the tilePanel
     */

    //create tilePanel
    public class createTilePanel extends JPanel{
        public createTilePanel(){
            this.setPreferredSize(new Dimension(50,50));
            this.setBackground(Color.LIGHT_GRAY);
        }
    }
    //add tile

    /**
     * <b>Transformer:</b> Function that adds a new tile into the "display tile" panel
     * @param number
     * @param imageTile
     */
    public void addTile(JPanel number,Image imageTile){
        number.setLayout(new FlowLayout());
        number.setPreferredSize(new Dimension(50,50));
        number.setBackground(Color.LIGHT_GRAY);
        Icon icon=new ImageIcon(getScaledImage(imageTile,50,50));
        number.setLayout(new BoxLayout(number,BoxLayout.X_AXIS));
        tile=new JLabel(icon);
        number.add(tile);
    }

    /**
     *SETTERS OF THE "TILE DISPLAY" PANELS
     */
    //set tilePanels
    public void setTilesOne(JPanel tilesOne){
        this.tilesOne=tilesOne;
    }
    public void setTilesTwo(JPanel tilesTwo){
        this.tilesTwo=tilesTwo;
    }
    public void setTilesThree(JPanel tilesThree){
        this.tilesThree=tilesThree;
    }
    public void setTilesFour(JPanel tilesFour){
        this.tilesFour=tilesFour;
    }

    /**
     *GETTERS OF THE "TILE DISPLAY" PANELS
     */
    //get tilePanels
    public JPanel getTilesOne(){return tilesOne;}
    public JPanel getTilesTwo(){return tilesTwo;}
    public JPanel getTilesThree(){return tilesThree;}
    public JPanel getTilesFour(){return tilesFour;}


    /**
     *Create option panel
     */
    //create the option panel
    public class createOptionPanel extends JPanel {
        public createOptionPanel() throws IOException {
            //Set the panel
            this.setBackground(Color.LIGHT_GRAY);
            this.setPreferredSize(new Dimension(370, 700));
        }
    }

    /**
     * <b>Transformer:</b> Adds the labels and the buttons at the current Option Panel
     * <b>postcondition:</b> the labels and the buttons at the current Option Panel has been added
     * @param panel
     * @param color
     */
    public void addPanelLabels(JPanel panel, ColorPlayer color){
        panel.setBackground(Color.lightGray);
        panel.setPreferredSize(new Dimension(370, 700));
        panel.setLayout(new GridBagLayout());
        //PLAYER CHARACTERS

        gbc.insets = new Insets(5, 5, 25, 5);
        //add the first label
        if (color == ColorPlayer.RED) {
            myLabel = new JLabel("<html><font color='red'><u>" + controller.Player1().getName() + "</u></font></html>");
        } else if (color == ColorPlayer.YELLOW) {
            myLabel = new JLabel("<html><font color='yellow'><u>" + controller.Player2().getName() + "</u></font></html>");
        } else if (color == ColorPlayer.BLACK) {
            myLabel = new JLabel("<html><font color='black'><u>" + controller.Player3().getName() + "</u></font></html>");
        } else {
            myLabel = new JLabel("<html><font color='blue'><u>" + controller.Player4().getName() + "</u></font></html>");
        }
        myLabel.setFont(new Font("ROMAN_BASELINE", Font.BOLD, 35));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        panel.add(myLabel, gbc);

        //add the first button (Archaeologist)
        icon = new ImageIcon(getScaledImage(archaeologist.getImage(), 140, 190));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        if(color==ColorPlayer.RED) {
            P1Chars[0].setIcon(icon);
            if (P1Chars[0].getActionListeners().length<1)
                P1Chars[0].addActionListener(new archaeologistListener());
            panel.add(P1Chars[0],gbc);
        }else if(color==ColorPlayer.YELLOW){
            P2Chars[0].setIcon(icon);
            if (P2Chars[0].getActionListeners().length<1)
                P2Chars[0].addActionListener(new archaeologistListener());
            panel.add(P2Chars[0],gbc);
        }else if(color==ColorPlayer.BLACK){
            P3Chars[0].setIcon(icon);
            if (P3Chars[0].getActionListeners().length<1)
                P3Chars[0].addActionListener(new archaeologistListener());
            panel.add(P3Chars[0],gbc);
        }else{
            P4Chars[0].setIcon(icon);
            if (P4Chars[0].getActionListeners().length<1)
                P4Chars[0].addActionListener(new archaeologistListener());
            panel.add(P4Chars[0],gbc);
        }

        //add the second button (Assistant)
        icon = new ImageIcon(getScaledImage(assistant.getImage(), 140, 190));
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.weightx = 0;
        gbc.weighty = 0;
        if(color==ColorPlayer.RED) {
            P1Chars[1].setIcon(icon);
            if (P1Chars[1].getActionListeners().length<1)
                P1Chars[1].addActionListener(new assistantListener());
            panel.add(P1Chars[1],gbc);
        }else if(color==ColorPlayer.YELLOW){
            P2Chars[1].setIcon(icon);
            if (P2Chars[1].getActionListeners().length<1)
                P2Chars[1].addActionListener(new assistantListener());
            panel.add(P2Chars[1],gbc);
        }else if(color==ColorPlayer.BLACK){
            P3Chars[1].setIcon(icon);
            if (P3Chars[1].getActionListeners().length<1)
                P3Chars[1].addActionListener(new assistantListener());
            panel.add(P3Chars[1],gbc);
        }else{
            P4Chars[1].setIcon(icon);
            if (P4Chars[1].getActionListeners().length<1)
                P4Chars[1].addActionListener(new assistantListener());
            panel.add(P4Chars[1],gbc);
        }

        //add the third button (Digger)
        icon = new ImageIcon(getScaledImage(digger.getImage(), 140, 190));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        if(color==ColorPlayer.RED) {
            P1Chars[2].setIcon(icon);
            if (P1Chars[2].getActionListeners().length<1)
                P1Chars[2].addActionListener(new diggerListener());
            panel.add(P1Chars[2],gbc);
        }else if(color==ColorPlayer.YELLOW){
            P2Chars[2].setIcon(icon);
            if (P2Chars[2].getActionListeners().length<1)
                P2Chars[2].addActionListener(new diggerListener());
            panel.add(P2Chars[2],gbc);
        }else if(color==ColorPlayer.BLACK){
            P3Chars[2].setIcon(icon);
            if (P3Chars[2].getActionListeners().length<1)
                P3Chars[2].addActionListener(new diggerListener());
            panel.add(P3Chars[2],gbc);
        }else{
            P4Chars[2].setIcon(icon);
            if (P4Chars[2].getActionListeners().length<1)
                P4Chars[2].addActionListener(new diggerListener());
            panel.add(P4Chars[2],gbc);
        }

        //add the fourth button (Professor)
        icon = new ImageIcon(getScaledImage(professor.getImage(), 140, 190));
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        if(color==ColorPlayer.RED) {
            P1Chars[3].setIcon(icon);
            if (P1Chars[3].getActionListeners().length<1)
                P1Chars[3].addActionListener(new professorListener());
            panel.add(P1Chars[3],gbc);
        }else if(color==ColorPlayer.YELLOW){
            P2Chars[3].setIcon(icon);
            if (P2Chars[3].getActionListeners().length<1)
                P2Chars[3].addActionListener(new professorListener());
            panel.add(P2Chars[3],gbc);
        }else if(color==ColorPlayer.BLACK){
            P3Chars[3].setIcon(icon);
            if (P3Chars[3].getActionListeners().length<1)
                P3Chars[3].addActionListener(new professorListener());
            panel.add(P3Chars[3],gbc);
        }else{
            P4Chars[3].setIcon(icon);
            if (P4Chars[3].getActionListeners().length<1)
                P4Chars[3].addActionListener(new professorListener());
            panel.add(P4Chars[3],gbc);
        }

        //add the fifth button (Draw Tiles)
        draw=new JButton("Draw Tiles");
        draw.addActionListener(new drawTilesListener());
        draw.setEnabled(true);
        draw.setPreferredSize(new Dimension(200, 150));
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.weighty = 0;
        panel.add(draw, gbc);

        //add the sixth button(End Turn)
        end=new JButton("End Turn");
        end.setEnabled(false);
        end.addActionListener(new endListener());
        end.setPreferredSize(new Dimension(200, 150));
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.weightx = 0;
        gbc.weighty = 0;
        panel.add(end, gbc);

        //add the final label
        myTiles = new JLabel("MY TILES:");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        myTiles.setFont(new Font("Alberta Light Regular ", Font.ITALIC, 27));
        panel.add(myTiles, gbc);

    }

    //set the panel
    /**
     *SETTERS OF THE OPTION PANELS
     */
    public void setPaneOne(JPanel paneOne){
        this.paneOne=paneOne;
    }
    public void setPaneTwo(JPanel paneTwo){
        this.paneTwo=paneTwo;
    }
    public void setPaneThree(JPanel paneThree){
        this.paneThree=paneThree;
    }
    public void setPaneFour(JPanel paneFour){
        this.paneFour=paneFour;
    }
    //get the panel
    /**
     *GETTERS OF THE OPTION PANELS
     */
    public JPanel getPaneOne(){return paneOne;}
    public JPanel getPaneTwo(){return paneTwo;}
    public JPanel getPaneThree(){return paneThree;}
    public JPanel getPaneFour(){return paneFour;}


    /**
     *Action Listeners
     */
    //FOR ASSISTANT
    public class assistantListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){

            //ENABLE OR DISABLE CHARACTERS BASED ON THE PACK OF CHARS OF THE PLAYER
            givePermission=1;
            if(controller.returnChars().getListCharacter().contains(controller.getArchaeologist()))
                takeChars()[0].setEnabled(false);
            if(controller.returnChars().getListCharacter().contains(controller.getAssistant()))
                takeChars()[1].setEnabled(false);
            if(controller.returnChars().getListCharacter().contains(controller.getDigger()))
                takeChars()[2].setEnabled(false);
            if(controller.returnChars().getListCharacter().contains(controller.getProfessor()))
                takeChars()[3].setEnabled(false);

            playSound("src\\sounds\\assi_hmm.wav");

            setitsProf(0);
            //MAKE BUTTONS ENABLE
            ableTiles("All",true);
            setCheck(1);
            //REMOVE CHARACTER FROM THE PLAYER
            controller.upgradeCharacters(controller.seeTurn(),"assistant");
            takeChars()[1].setVisible(false);
        }
    }
    //FOR PROFESSOR
    public class professorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(!lastTile(1).equals("ERROR")) {

                //ENABLE OR DISABLE CHARACTERS BASED ON THE PACK OF CHARS OF THE PLAYER
                givePermission=1;
                if(controller.returnChars().getListCharacter().contains(controller.getArchaeologist()))
                    takeChars()[0].setEnabled(false);
                if(controller.returnChars().getListCharacter().contains(controller.getAssistant()))
                    takeChars()[1].setEnabled(false);
                if(controller.returnChars().getListCharacter().contains(controller.getDigger()))
                    takeChars()[2].setEnabled(false);
                if(controller.returnChars().getListCharacter().contains(controller.getProfessor()))
                    takeChars()[3].setEnabled(false);

                playSound("src\\sounds\\prof_hmm.wav");
                //MAKE BUTTONS DISABLED
                ableTiles("All", false);
                //ABLE THE LOCATIONS EXCEPT THE LAST ONE LOCATION
                ableTiles(lastTile(1), true);
                setitsProf(1);
                //REMOVE CHARACTER FROM THE PLAYER
                controller.upgradeCharacters(controller.seeTurn(), "professor");
                takeChars()[3].setVisible(false);
            }else{
                playSound("src\\sounds\\error.wav");
                System.out.println("ERROR: You haven't draw a tile yet!");
            }
        }
    }
    //FOR ARCHAEOLOGIST
    public class archaeologistListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(!lastTile(1).equals("ERROR")) {

                //ENABLE OR DISABLE CHARACTERS BASED ON THE PACK OF CHARS OF THE PLAYER
                givePermission=1;
                if(controller.returnChars().getListCharacter().contains(controller.getArchaeologist()))
                    takeChars()[0].setEnabled(false);
                if(controller.returnChars().getListCharacter().contains(controller.getAssistant()))
                    takeChars()[1].setEnabled(false);
                if(controller.returnChars().getListCharacter().contains(controller.getDigger()))
                    takeChars()[2].setEnabled(false);
                if(controller.returnChars().getListCharacter().contains(controller.getProfessor()))
                    takeChars()[3].setEnabled(false);

                setitsProf(0);
                playSound("src\\sounds\\arch_hmm.wav");
                //FALSE THE TILES
                ableTiles("All", false);
                //ABLE THE LOCATIONS EXCEPT THE LAST ONE LOCATION
                ableTiles(lastTile(1), true);
                setCheck(0);
                //REMOVE CHARACTER FROM THE PLAYER
                controller.upgradeCharacters(controller.seeTurn(), "archaeologist");
                takeChars()[0].setVisible(false);
            }else{
                playSound("src\\sounds\\error.wav");
                System.out.println("ERROR: You haven't draw a tile yet!");
            }
        }
    }
    //FOR DIGGER
    public class diggerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(!lastTile(1).equals("ERROR")) {

                //ENABLE OR DISABLE CHARACTERS BASED ON THE PACK OF CHARS OF THE PLAYER
                givePermission=1;
                if(controller.returnChars().getListCharacter().contains(controller.getArchaeologist()))
                    takeChars()[0].setEnabled(false);
                if(controller.returnChars().getListCharacter().contains(controller.getAssistant()))
                    takeChars()[1].setEnabled(false);
                if(controller.returnChars().getListCharacter().contains(controller.getDigger()))
                    takeChars()[2].setEnabled(false);
                if(controller.returnChars().getListCharacter().contains(controller.getProfessor()))
                    takeChars()[3].setEnabled(false);

                setitsProf(0);
                playSound("src\\sounds\\dig_hmm.wav");
                //FALSE TILES
                ableTiles("All", true);
                setCheck(0);
                //ABLE THE LOCATIONS EXCEPT THE LAST ONE LOCATION
                ableTiles(lastTile(1), false);
                //REMOVE CHARACTER FROM THE PLAYER
                controller.upgradeCharacters(controller.seeTurn(),"digger");
                takeChars()[2].setVisible(false);
            }else{
                playSound("src\\sounds\\error.wav");
                System.out.println("ERROR: You haven't draw a tile yet!");
            }
        }
    }
    //FOR DRAW
    public class drawTilesListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //play sound
            playSound("src\\sounds\\keys.wav");

            //draw the tiles
            controller.drawTiles();
            //if the bag is empty
            if(controller.isOneToMillion()){
                playSound("src\\sounds\\error.wav");
                System.out.println("BAG TILES HAVE FINISHED");
                System.exit(0);
            }
            //remove all the locations from the tiles
            getLocationAmphores().removeAll();
            getLocationMosaics().removeAll();
            getLocationStatues().removeAll();
            getLocationSkeletons().removeAll();
            getLocationEntrance().removeAll();

            //add the tiles that have been drawn to the specific array list and then REDISPLAY all the lists again
            addButtonTile(controller.getBoard().getListLocationMosaics(),controller.getBoard().getListLocationMosaics().size());
            addButtonTile(controller.getBoard().getListLocationStatues(),controller.getBoard().getListLocationStatues().size());
            addButtonTile(controller.getBoard().getListLocationAmphores(),controller.getBoard().getListLocationAmphores().size());
            addButtonTile(controller.getBoard().getListLocationSkeletons(),controller.getBoard().getListLocationSkeletons().size());
            if(controller.getBoard().getListLocationEntrance().size()!=0)
                addButtonTile(controller.getBoard().getListLocationEntrance(),controller.getBoard().getListLocationEntrance().size());

            //setCover equal to the size of the list of entrance
            setCover(controller.getBoard().getListLocationEntrance().size());
            //if it is >=16 go to endGame method
            if(getCover()>=16) {
                endGame();
                System.out.println("Thanks for playing!!!");
            }
            //MAKE THE BUTTONS ENABLE SO AS THE PLAYER CAN CLICK THEM
            ableTiles("All",true);

            //REPAINT AND REVALIDATE THE BOARD AND HIS PANELS
            getBoard().repaint();
            getBoard().revalidate();
            //FALSE THE DRAW BUTTON
            draw.setEnabled(false);
        }
    }

    //FOR END TURN
    public class endListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            //play sound
            playSound("src\\sounds\\keys.wav");
            setCheck(0);
            setitsProf(0);
            givePermission=0;
            //DISABLE ALL THE CHARACTERS AND TILES
            ableTiles("All",false);
            for(int i=0; i<4; i++){
                P1Chars[i].setEnabled(false);
                P2Chars[i].setEnabled(false);
                P3Chars[i].setEnabled(false);
                P4Chars[i].setEnabled(false);
            }

            //IT WILL EXECUTED ONLY ONE TIME
            if(getToInitialize()==0) {
                //INITIALIZE THE PANELS
                //First 2
                try {
                    setPaneTwo(new createOptionPanel());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                setTilesTwo(new createTilePanel());
                //DEPENDING OF THE FIRST COLOR SET PANE TWO TO THE NEXT COLOR
                if(getCurrentColor()==ColorPlayer.RED) {
                    setYellowPanel(getPaneTwo());
                    setYellowTiles(getTilesTwo());
                }else if(getCurrentColor()==ColorPlayer.YELLOW){
                    setBlackPanel(getPaneTwo());
                    setBlackTiles(getTilesTwo());
                }else if(getCurrentColor()==ColorPlayer.BLACK){
                    setBluePanel(getPaneTwo());
                    setBluePanel(getTilesTwo());
                }else if(getCurrentColor()==ColorPlayer.BLUE){
                    setRedPanel(getPaneTwo());
                    setRedTiles(getTilesTwo());
                }


                //After 3
                try {
                    setPaneThree(new createOptionPanel());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                setTilesThree(new createTilePanel());
                //DEPENDING OF THE FIRST COLOR SET PANE THREE TO THE NEXT COLOR
                if(getCurrentColor()==ColorPlayer.RED) {
                    setBlackPanel(getPaneThree());
                    setBlackTiles(getTilesThree());
                }else if(getCurrentColor()==ColorPlayer.YELLOW){
                    setBluePanel(getPaneThree());
                    setBlueTiles(getTilesThree());
                }else if(getCurrentColor()==ColorPlayer.BLACK){
                    setRedPanel(getPaneThree());
                    setRedTiles(getTilesThree());
                }else if(getCurrentColor()==ColorPlayer.BLUE){
                    setYellowPanel(getPaneThree());
                    setYellowTiles(getTilesThree());
                }

                //Final 4
                try {
                    setPaneFour(new createOptionPanel());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                setTilesFour(new createTilePanel());
                //DEPENDING OF THE FIRST COLOR SET PANE FOUR TO THE NEXT COLOR
                if(getCurrentColor()==ColorPlayer.RED) {
                    setBluePanel(getPaneFour());
                    setBlueTiles(getTilesFour());
                }else if(getCurrentColor()==ColorPlayer.YELLOW){
                    setRedPanel(getPaneFour());
                    setRedTiles(getTilesFour());
                }else if(getCurrentColor()==ColorPlayer.BLACK){
                    setYellowPanel(getPaneFour());
                    setYellowTiles(getTilesFour());
                }else if(getCurrentColor()==ColorPlayer.BLUE){
                    setBlackPanel(getPaneFour());
                    setBlackTiles(getTilesFour());
                }
                setToInitialize(getToInitialize() + 1);
                //coloringPanels();
            }

            //REMOVE THE INNERS OF CURRENT OPTION PANEL AND "DISPLAY TILES" PANEL
            getCurrentPane().removeAll();
            getCurrentTiles().removeAll();

            //LET'S START!!!
            //GET THE CURRENT COLOR AND DEPENDING ON THAT MAKE THE BELOW ENERGIES
            if(getCurrentColor()==ColorPlayer.RED){
                //REMOVE THE CURRENT OPTION PANEL AND "DISPLAY TILES" PANEL FROM THE FRAME
                getFrame().remove(getCurrentPane());
                getFrame().remove(getCurrentTiles());

                //SET THE NEXT COLOR INTO CURRENT PANE AND "DISPLAY TILES" PANEL
                setCurrentPane(getYellowPanel());
                addPanelLabels(getCurrentPane(),ColorPlayer.YELLOW);
                setCurrentTiles(getYellowTiles());
                //ADD THE TILES FROM THE CURRENT PLAYER TO THE "DISPLAY TILES" PANEL
                for(int u=0; u<controller.getP2Tiles().getListTile().size(); u++)
                    addTile(getCurrentTiles(),controller.getP2Tiles().getTiLe(u).getTileImage());

                //REVALIDATE AND REPAINT THEM
                getCurrentPane().repaint();
                getCurrentPane().revalidate();

                getCurrentTiles().repaint();
                getCurrentTiles().revalidate();

                //ADD CURRENT PANE AND TILES TO THE FRAME AND REPAINT/VALIDATE IT
                getFrame().add(getCurrentPane(),"West");
                getFrame().add(getCurrentTiles(),"South");

                getFrame().revalidate();
                getFrame().repaint();

            //MAKE THE SAME WORK FOR THE OTHER COLORS
            }else if(getCurrentColor()==ColorPlayer.YELLOW){
                getFrame().remove(getCurrentPane());
                getFrame().remove(getCurrentTiles());

                setCurrentPane(getBlackPanel());
                addPanelLabels(getCurrentPane(),ColorPlayer.BLACK);
                setCurrentTiles(getBlackTiles());
                for(int u=0; u<controller.getP3Tiles().getListTile().size(); u++)
                    addTile(getCurrentTiles(),controller.getP3Tiles().getTiLe(u).getTileImage());

                getCurrentPane().repaint();
                getCurrentPane().revalidate();

                getCurrentTiles().repaint();
                getCurrentTiles().revalidate();

                getFrame().add(getCurrentPane(),"West");
                getFrame().add(getCurrentTiles(),"South");

                getFrame().revalidate();
                getFrame().repaint();
            }else if(getCurrentColor()==ColorPlayer.BLACK){
                getFrame().remove(getCurrentPane());
                getFrame().remove(getCurrentTiles());

                setCurrentPane(getBluePanel());
                addPanelLabels(getCurrentPane(),ColorPlayer.BLUE);
                setCurrentTiles(getBlueTiles());
                for(int u=0; u<controller.getP4Tiles().getListTile().size(); u++)
                    addTile(getCurrentTiles(),controller.getP4Tiles().getTiLe(u).getTileImage());

                getCurrentPane().repaint();
                getCurrentPane().revalidate();

                getCurrentTiles().repaint();
                getCurrentTiles().revalidate();

                getFrame().add(getCurrentPane(),"West");
                getFrame().add(getCurrentTiles(),"South");

                getFrame().revalidate();
                getFrame().repaint();
            }else if(getCurrentColor()==ColorPlayer.BLUE){
                getFrame().remove(getCurrentPane());
                getFrame().remove(getCurrentTiles());

                setCurrentPane(getRedPanel());
                addPanelLabels(getCurrentPane(),ColorPlayer.RED);
                setCurrentTiles(getRedTiles());
                for(int u=0; u<controller.getP1Tiles().getListTile().size(); u++)
                    addTile(getCurrentTiles(),controller.getP1Tiles().getTiLe(u).getTileImage());

                getCurrentPane().repaint();
                getCurrentPane().revalidate();

                getCurrentTiles().repaint();
                getCurrentTiles().revalidate();

                getFrame().add(getCurrentPane(),"West");
                getFrame().add(getCurrentTiles(),"South");

                getFrame().revalidate();
                getFrame().repaint();
            }

            //GO TO NEXT COLOR
            controller.endTurn();
            setCurrentColor(controller.seeTurn());
        }
    }

    //FOR EVERY JBUTTON TILE
    //for mosaic
    public class buttonTileListener implements ActionListener {
        private int num;
        public buttonTileListener(int which) {
            num=which;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //Play a sound
            playSound("src\\sounds\\clicki.wav");

            //DEPENDING OF THE SOURCE : REMOVE ALL THE TILES FROM THE LOCATION ,REMOVE THE TILE FROM THE LIST, ADD ALL THE LIST AGAIN
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (num == 1) {
                        if (mosaicsButtons[i][j] == e.getSource()) {
                            controller.upgradeHand(controller.getBoard().getLocationMosaics(4 * i + j));
                            controller.getBoard().removeLocationMosaics(controller.getBoard().getLocationMosaics(4 * i + j));
                            getLocationMosaics().removeAll();
                            addButtonTile(controller.getBoard().getListLocationMosaics(), controller.getBoard().getListLocationMosaics().size());
                            getLocationMosaics().repaint();
                            getLocationMosaics().revalidate();
                        }
                    } else if (num == 2) {
                        if (statuesButtons[i][j] == e.getSource()) {
                            controller.upgradeHand(controller.getBoard().getLocationStatues(4 * i + j));
                            controller.getBoard().removeLocationStatues(controller.getBoard().getLocationStatues(4 * i + j));
                            getLocationStatues().removeAll();
                            addButtonTile(controller.getBoard().getListLocationStatues(), controller.getBoard().getListLocationStatues().size());
                            getLocationStatues().repaint();
                            getLocationStatues().revalidate();
                        }
                    } else if (num == 3) {
                        if (amphoresButtons[i][j] == e.getSource()) {
                            controller.upgradeHand(controller.getBoard().getLocationAmphores(4 * i + j));
                            controller.getBoard().removeLocationAmhpores(controller.getBoard().getLocationAmphores(4 * i + j));
                            getLocationAmphores().removeAll();
                            addButtonTile(controller.getBoard().getListLocationAmphores(), controller.getBoard().getListLocationAmphores().size());
                            getLocationAmphores().repaint();
                            getLocationAmphores().revalidate();
                        }
                    } else {
                        if (skeletonsButtons[i][j] == e.getSource()) {
                            controller.upgradeHand(controller.getBoard().getLocationSkeletons(4 * i + j));
                            controller.getBoard().removeLocationSkeletons(controller.getBoard().getLocationSkeletons(4 * i + j));
                            getLocationSkeletons().removeAll();
                            addButtonTile(controller.getBoard().getListLocationSkeletons(), controller.getBoard().getListLocationSkeletons().size());
                            getLocationSkeletons().repaint();
                            getLocationSkeletons().revalidate();
                        }
                    }
                }
            }

            //REMOVE ALSO THE "DISPLAY TILE" PANEL AND REVALIDATE AGAIN WITH THE EXTRA TILE THAT BEEN ADDED
            getCurrentTiles().removeAll();
            //add tile to players pack
            for (int u = 0; u < takePack().getListTile().size(); u++)
                addTile(getCurrentTiles(), takePack().getTiLe(u).getTileImage());

            //if is pushed professor
            //THEN FALSE THE LOCATION WHEN THE TILE HAS BEEN TAKEN
            if (getitsProf() == 1) {
                falseLocation(lastTile(1));
                end.setEnabled(true);
            }else{

                //if getCheck() is zero enable them all
                ableTiles("All", true);
                setCheck(getCheck() + 1);

                //ENABLE OR DISABLE CHARACTERS BASED ON THE PACK OF CHARS OF THE PLAYER
                if(givePermission==0) {
                    if (!controller.returnChars().getListCharacter().contains(controller.getArchaeologist()))
                        takeChars()[0].setEnabled(false);
                    else
                        takeChars()[0].setEnabled(true);
                    if (!controller.returnChars().getListCharacter().contains(controller.getAssistant()))
                        takeChars()[1].setEnabled(false);
                    else
                        takeChars()[1].setEnabled(true);
                    if (!controller.returnChars().getListCharacter().contains(controller.getDigger()))
                        takeChars()[2].setEnabled(false);
                    else
                        takeChars()[2].setEnabled(true);
                    if (!controller.returnChars().getListCharacter().contains(controller.getProfessor()))
                        takeChars()[3].setEnabled(false);
                    else
                        takeChars()[3].setEnabled(true);
                }

                //if checker is 1 you can take tiles only from the location you took before
                if (getCheck() == 1) {
                    //if the tile you choose was mosaic
                    if (num == 1) {
                        ableTiles("Mosaic", false);
                        //if the button you choose was statue
                    } else if (num == 2) {
                        ableTiles("Statue", false);
                        //if the button you choose was amphoreas
                    } else if (num == 3) {
                        ableTiles("Amphoreas", false);
                    } else {
                        //if the button was skeleton
                        ableTiles("Skeleton", false);
                    }
                }

                //IF YOU DRAWN A TILE AND THE LOCATION IS EMPTY
                if (getCheck() == 1) {
                    if (num == 1) {
                        if (mosaicsButtons[0][0].getParent() == null)
                            setCheck(0);
                    } else if (num == 2) {
                        if (statuesButtons[0][0].getParent() == null)
                            setCheck(0);
                    } else if (num == 3) {
                        if (amphoresButtons[0][0].getParent() == null)
                            setCheck(0);
                    } else if (num == 4) {
                        if (skeletonsButtons[0][0].getParent() == null)
                            setCheck(0);
                    }
                    end.setEnabled(true);
                }
                //if checker is 2 ALL THE TILES ARE FALSE SO MAKE ANOTHER OPTION
                if (getCheck() == 2) {
                    ableTiles("All", false);
                    setCheck(0);
                    end.setEnabled(true);
                }
            }
        }
    }


    //for sounds (i stole the method from the previous project :P)
    public void playSound(String soundName)
    {
        try
        {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName));
            Clip clip = AudioSystem.getClip( );
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
