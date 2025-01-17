import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Objects;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IOException {

        int highScore = 0;

        Game new2048;
        new2048 = new Game();
        new2048.generateTile();
        new2048.generateTile();
        printGame(new2048.getArray());

        //overall frame
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color (249, 248, 240));
        frame.setOpacity(1);
        frame.setSize(400,500);
        JLabel backGround = new JLabel();
        frame.add(backGround);

        //creates background which will hold board and tiles
        backGround.setLayout(null);
        backGround.setBounds(7, 70, 400, 370);
        backGround.setOpaque(true);
        ImageIcon board = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/board.png")));
        backGround.setIcon(board);

        //transparent lost filter
        JLabel lost = new JLabel();
        lost.setSize(370, 390);
        lost.setVisible(true);
        lost.setOpaque(true);
        lost.setBackground(new Color(238, 228, 218, 0));
        backGround.add(lost);

        //information at the top
        JLabel information = new JLabel();
        ImageIcon info = new ImageIcon(Objects.requireNonNull(Main.class.getResource("/info.png")));
        information.setIcon(info);
        information.setVisible(true);
        frame.add(information);
        information.setLocation(8,-18);
        information.setSize(200, 98);

        //transparent winning filter
        JLabel win = new JLabel();
        win.setSize(370, 370);
        win.setVisible(true);
        win.setOpaque(true);
        win.setBackground(new Color(255, 204, 0, 0));
        backGround.add(win);

        //scores
        JLabel textarea = new JLabel ("Score:         High Score:" );
        textarea.setFont(new Font("SansSerif", Font.BOLD, 15));
        textarea.setForeground(new Color(120,108,100));
        textarea.setVisible(true);
        textarea.setOpaque(true);
        textarea.setLocation(215, 5);
        textarea.setSize(200,30);
        textarea.setBackground(new Color (249, 248, 240));
        frame.add(textarea);

        JLabel score = new JLabel ("0");
        score.setFont(new Font("SansSerif", Font.BOLD, 15));
        score.setForeground(new Color(120,108,100));
        score.setVisible(true);
        score.setOpaque(true);
        score.setLocation(215, 32);
        score.setSize(80,30);
        score.setBackground(new Color (249, 248, 240));
        frame.add(score);


        showGame(backGround, new2048.getArray());

        backGround.setComponentZOrder(win, 0);
        backGround.repaint();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //load score
        BufferedReader read = new BufferedReader(new FileReader("src/High Score.txt"));
        String hs = read.readLine();
        if (hs != null) {
            highScore = Integer.parseInt(hs);
        }


        BufferedWriter writer = new BufferedWriter(new FileWriter("src/High Score.txt"));


        int[] finalHighScore = {highScore};

        JLabel highScoreLabel = new JLabel (Integer.toString(highScore));
        highScoreLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
        highScoreLabel.setForeground(new Color(120,108,100));
        highScoreLabel.setVisible(true);
        highScoreLabel.setOpaque(true);
        highScoreLabel.setLocation(297, 32);
        highScoreLabel.setSize(95,30);
        highScoreLabel.setBackground(new Color (249, 248, 240));
        frame.add(highScoreLabel);
        frame.setLayout(null);


            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {

                }

                @Override
                public void keyPressed(KeyEvent e) {

                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            if (new2048.left()) {
                                backGround.removeAll();
                                System.out.println("left: ");
                                try {
                                    handleLoss(new2048, backGround, lost, frame, highScoreLabel);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }

                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (new2048.right()) {
                                backGround.removeAll();

                                System.out.println("right: ");

                                try {
                                    handleLoss(new2048, backGround, lost, frame, highScoreLabel);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }

                            break;
                        case KeyEvent.VK_UP:
                            if (new2048.up()) {

                                backGround.removeAll();
                                System.out.println("up: ");

                                try {
                                    handleLoss(new2048, backGround, lost, frame, highScoreLabel);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }

                            break;
                        case KeyEvent.VK_DOWN:
                            if (new2048.down()) {

                                backGround.removeAll();
                                System.out.println("down: ");

                                try {
                                    handleLoss(new2048, backGround, lost, frame, highScoreLabel);
                                } catch (InterruptedException ex) {
                                    throw new RuntimeException(ex);
                                }

                            }
                            break;

                        case KeyEvent.VK_R:
                            new2048.resetGame();
                            new2048.generateTile();
                            new2048.generateTile();
                            backGround.removeAll();
                            showGame(backGround, new2048.getArray());
                            printGame(new2048.getArray());
                            System.out.println("score: " + new2048.score);
                            System.out.println();
                            break;
                    }
                        if (finalHighScore[0] < new2048.score) {
                            finalHighScore[0] = new2048.score;
                            highScoreLabel.setText(String.valueOf(new2048.score));
                            score.setText(String.valueOf(new2048.score));
                        }

                    //if lost, skip everything
                        if (!new2048.lost) {
                            score.setText(new2048.score.toString());

                            score.repaint();
                            if (new2048.triggerWin) {
                                frame.remove(highScoreLabel);
                                backGround.add(win);
                                backGround.setComponentZOrder(win, 0);


                                win.setOpaque(true);
                                win.setVisible(true);


                                win.setForeground(new Color(255,255,255));
                                win.setHorizontalAlignment(SwingConstants.CENTER);
                                win.setFont(new Font("SansSerif", Font.BOLD, 30));
                                win.setText("You win!");

                                backGround.repaint();

                                ActionListener winFadeIn = new ActionListener() {

                                    double currColor = 0;
                                    int timeOut = 600;
                                    int elapsedTime = 0;
                                    public void actionPerformed(ActionEvent evt) {

                                        elapsedTime += 20;
                                        if (currColor < 255) {
                                            currColor += 0.3;
                                            win.setBackground(new Color(255, 204, 0, (int) currColor));
                                            win.repaint();

                                        }
                                        if (elapsedTime >= timeOut) {
                                            Timer s = (Timer)evt.getSource();
                                            s.stop();
                                            frame.add(highScoreLabel);
                                        }

                                    }
                                };
                                Timer timer = new Timer(20, winFadeIn);
                                timer.start();
                            }
                        }

                }

                @Override
                public void keyReleased(KeyEvent e) {}
            });


        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    writer.write(Integer.toString(finalHighScore[0]));
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    private static void handleLoss(Game new2048, JLabel backGround, JLabel lost, JFrame frame, JLabel highScore)
            throws InterruptedException {
        if (new2048.generateTile() && !new2048.gameContinue()) {
            frame.remove(highScore);
            new2048.lost = true;
            backGround.add(lost);
            backGround.setComponentZOrder(lost, 0);
            showGame(backGround, new2048.getArray());
            backGround.repaint();
            lost.setOpaque(true);
            lost.setForeground(new Color(116,100,84));
            lost.setFont(new Font("SansSerif", Font.BOLD, 40));
            lost.setHorizontalAlignment(SwingConstants.CENTER);
            lost.setText("Game Over!");

            ActionListener lostFadeIn = new ActionListener() {
                double currColor = 0;
                int timeOut = 600;
                int elapsedTime = 0;
                public void actionPerformed(ActionEvent evt) {

                    elapsedTime += 20;
                    if (currColor < 255) {
                        currColor += 0.3;
                        lost.setBackground(new Color(238, 228, 218, (int) currColor));
                        lost.repaint();
                    }
                    if (elapsedTime >= timeOut) {
                        Timer s = (Timer)evt.getSource();
                        s.stop();
                        frame.add(highScore);
                    }

                }
            };
            Timer timer = new Timer(20, lostFadeIn);
            timer.start();

            printGame(new2048.getArray());
            System.out.println("You lost! Your final score is " + new2048.score);
            System.out.println();
            return;
        }
        showGame(backGround, new2048.getArray());
        printGame(new2048.getArray());
        System.out.println("score: " + new2048.score);
        System.out.println();
    }

    //created for debugging/ quicker general correctness check than the tiles test cases
    static void printGame(int[][] gameArray) {
        for (int[] x : gameArray) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }

    }
    static void showGame(JLabel backGround, int[][] new2048) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int number = new2048[i][j];
                switch(number) {
                    //shoud be j, i
                    case 0:
                        break;
                    case 2:
                        JLabel newTile = new gameTiles(colors.TILE_2, j, i).tile;
                        newTile.setText("2");
                        backGround.add(newTile);
                        break;
                    case 4:
                        JLabel newTile1 = new gameTiles(colors.TILE_4, j, i).tile;
                        newTile1.setText("4");
                        backGround.add(newTile1);
                        break;
                    case 8:
                        JLabel newTile2 = new gameTiles(colors.TILE_8, j, i).tile;
                        newTile2.setText("8");
                        backGround.add(newTile2);
                        break;
                    case 16:
                        JLabel newTile3 = new gameTiles(colors.TILE_16, j, i).tile;
                        newTile3.setText("16");
                        backGround.add(newTile3);
                        break;
                    case 32:
                        JLabel newTile4 = new gameTiles(colors.TILE_32, j, i).tile;
                        newTile4.setText("32");
                        backGround.add(newTile4);
                        break;
                    case 64:
                        JLabel newTile5 = new gameTiles(colors.TILE_64, j, i).tile;
                        newTile5.setText("64");
                        backGround.add(newTile5);
                        break;
                    case 128:
                        JLabel newTile6 = new gameTiles(colors.TILE_128, j, i).tile;
                        newTile6.setText("128");
                        backGround.add(newTile6);
                        break;
                    case 256:
                        JLabel newTile7 = new gameTiles(colors.TILE_256, j, i).tile;
                        newTile7.setText("256");
                        backGround.add(newTile7);
                        break;
                    case 512:
                        JLabel newTile8 = new gameTiles(colors.TILE_512, j, i).tile;
                        newTile8.setText("512");
                        backGround.add(newTile8);
                        break;
                    case 1024:
                        JLabel newTile9 = new gameTiles(colors.TILE_1024, j, i).tile;
                        newTile9.setText("1024");
                        backGround.add(newTile9);
                        break;
                    case 2048:
                        JLabel newTile10 = new gameTiles(colors.TILE_2048, j, i).tile;
                        newTile10.setText("2048");
                        backGround.add(newTile10);
                        break;
                    default:
                        JLabel newTile11 = new gameTiles(colors.TILE_BIG, j, i).tile;
                        newTile11.setText(String.valueOf(number));
                        backGround.add(newTile11);
                        break;
                }
            }
        }
        backGround.repaint();
    }
}