/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mkproject.resources;

import java.io.IOException;
import javafx.scene.text.Font;

/**
 *
 * @author Ashenafi
 */
public class ResourceLoader {
        public static void main(String args[]){
            loadFonts();
}

    /**
     *
     */
    public static void loadFonts() {
        //Fonts nyala = new Fonts("nyala.ttf");
        //return Fonts.addFont(nyala);
        Fontfx nyala = new Fontfx("nyala.ttf");
        Fontfx.addFont(nyala);
    }
}
