package com.game.cis350.mascot.presenters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.game.cis350.mascot.models.Animations;
import com.game.cis350.mascot.models.Model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class holds presenter information that should persist for the whole game.
 * @author Reuben, Ariel 11/19/2017
 */

public abstract class PresenterInfo {
    /**
     * This stores the images to be displayed on the view.  The reason this can't be in the model
     * is because the model would then become platform specific, which we want to avoid.  Instead,
     * the model will store the paths to the images using String, which is native to Java.
     * credit https://stackoverflow.com/questions/29061292/c-sharp-mvc-how-to-save-image-to-my-model
     */
    private static HashMap<String, Bitmap> images;

    /**
     * This initializes the variables.
     * @param context context needed to create bitmaps
     */
    public static void create(final Context context) {
        images = new HashMap<>();

        //get the file paths for the main player
        ArrayList<String> filePaths = new ArrayList<>();
        for (String s : Animations.PLAYER) {
            filePaths.add(s);
        }
        //get the file paths for the right moving busses
        for (String s : Animations.BUS) {
            filePaths.add(s);
        }

        //get the file paths for the left moving busses
        for (String s : Animations.BUS_LEFT) {
            filePaths.add(s);
        }

        //get the file paths for the right moving boats
        for (String s : Animations.BOAT) {
            filePaths.add(s);
        }

        //get the file paths for the left moving boats
        for (String s : Animations.BOAT_LEFT) {
            filePaths.add(s);
        }

        //get the file paths for the grass
        for (String s : Animations.GRASS) {
            filePaths.add(s);
        }

        //get the file paths for the bush
        for (String s : Animations.BUSH) {
            filePaths.add(s);
        }

        //get the file paths for the water
        for (String s : Animations.WATER) {
            filePaths.add(s);
        }

        //get the file paths for the top road
        for (String s : Animations.ROAD_TOP) {
            filePaths.add(s);
        }

        //get the file paths for the bottom road
        for (String s : Animations.ROAD_BOTTOM) {
            filePaths.add(s);
        }

        //get the file paths for the win tile
        for (String s : Animations.WIN) {
            filePaths.add(s);
        }

        //create the bitmaps and store them in the hashmap
        //credit https://stackoverflow.com/questions/25034782/dynamically-choosing-drawable
        for (String s: filePaths) {
            try {
                Bitmap temp = BitmapFactory.decodeResource(context.getResources(), context.getResources().getIdentifier(s, "drawable", "com.game.cis350.mascot"));
                //scale the bitmaps so that they're a multiple of the player's "steps", to prevent misalignment when the player moves
                temp = Bitmap.createScaledBitmap(temp, (((int) temp.getWidth() / Model.STEPS) * Model.STEPS), (((int) temp.getHeight() / Model.STEPS) * Model.STEPS), false);

                images.put(s, temp);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * This method returns the images.
     * @return image mapping
     */
    public static HashMap<String, Bitmap> getImages() {
        return images;
    }

}
