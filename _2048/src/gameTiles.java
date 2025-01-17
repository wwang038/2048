import javax.swing.*;
import java.awt.*;



public class gameTiles {
    JLabel tile;
    colors color;

    gameTiles(colors color, int x, int y) {

        this.color = color;
        this.tile = new JLabel("", JLabel.CENTER);

        this.tile.setSize(78,78);
        this.tile.setBackground(color.color);
        this.tile.setVisible(true);
        this.tile.setOpaque(true);

        if (color == colors.TILE_2) {
            this.tile.setForeground(new Color(124,108,100));
            this.tile.setFont(new Font("SansSerif", Font.BOLD, 50));
        }
        if (color == colors.TILE_4) {
            this.tile.setForeground(new Color(120,108,100));
            this.tile.setFont(new Font("SansSerif", Font.BOLD, 50));
        }
        if (color == colors.TILE_8 || color == colors.TILE_16 || color == colors.TILE_32 || color == colors.TILE_64) {
            this.tile.setForeground(new Color(255, 255, 255));
            this.tile.setFont(new Font("SansSerif", Font.BOLD, 50));
        }
        if (color == colors.TILE_128 || color == colors.TILE_256 || color == colors.TILE_512) {
            this.tile.setForeground(new Color(255, 255, 255));
            this.tile.setFont(new Font("SansSerif", Font.BOLD, 30));
        }

        if (color == colors.TILE_1024 || color == colors.TILE_2048) {
            this.tile.setForeground(new Color(255, 255, 255));
            this.tile.setFont(new Font("SansSerif", Font.BOLD, 23));
        }

        if (color == colors.TILE_BIG) {
            this.tile.setForeground(new Color(255, 255, 255));
            this.tile.setFont(new Font("SansSerif", Font.BOLD, 20));
        }
        if (x == 0) {
            if (y == 0) {
                this.tile.setLocation(10, 16);
            }
            if (y == 1) {
                this.tile.setLocation(10, 16 + 90 + 1);
            }
            if (y == 2) {
                this.tile.setLocation(10, 16 + 180 + 1);
            }
            if (y == 3) {
                this.tile.setLocation(10, 16 + 270 + 2);
            }
        }

        if (x == 1) {
            if (y == 0) {
                this.tile.setLocation(100, 16);
            }
            if (y == 1) {
                this.tile.setLocation(10 + 90, 16 + 90 + 1);
            }
            if (y == 2) {
                this.tile.setLocation(100, 16 + 180 + 1);
            }
            if (y == 3) {
                this.tile.setLocation(100, 16 + 270 + 2);
            }
        }
        if (x == 2) {
            if (y == 0) {
                this.tile.setLocation(100 + 90, 16);
            }
            if (y == 1) {
                this.tile.setLocation(190, 16 + 90 + 1);
            }
            if (y == 2) {
                this.tile.setLocation(190, 16 + 180 + 1);
            }
            if (y == 3) {
                this.tile.setLocation(190, 16 + 270 + 2);
            }
        }
        if (x == 3) {
            if (y == 0) {
                this.tile.setLocation(100 + 180, 16);
            }
            if (y == 1) {
                this.tile.setLocation(100 + 180, 16 + 90 + 1);
            }
            if (y == 2) {
                this.tile.setLocation(100 + 180, 16 + 180 + 1);
            }
            if (y == 3) {
                this.tile.setLocation(100 + 180, 16 + 270 + 2);
            }
        }

        this.tile.setLocation(this.tile.getLocation().x, this.tile.getLocation().y - 5);
    }
}
