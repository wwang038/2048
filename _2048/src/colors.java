import java.awt.*;

public enum colors {
    TILE_2(new Color(238, 228, 218)),

    TILE_4(new Color(237, 224, 200)),
    TILE_8(new Color(242, 177, 121)),
    TILE_16(new Color(245, 149, 99)),
    TILE_32(new Color(246, 124, 95)),
    TILE_64(new Color(246, 94, 59)),
    TILE_128(new Color(237, 207, 114)),
    TILE_256(new Color(237, 204, 97)),
    TILE_512(new Color(237, 200, 80)),
    TILE_1024(new Color(237, 197, 63)),
    TILE_2048(new Color(237, 194, 46)),
    TILE_BIG(new Color(64,60,52));


    Color color;
    colors(Color color) {
        this.color = color;
    }
}
