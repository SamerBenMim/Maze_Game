package TileObjects.Items;

import TileObjects.TileObject;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Item extends TileObject {

    public Item(String name, String stringRepresentation) {
        super( "", "", false);
    }
}

