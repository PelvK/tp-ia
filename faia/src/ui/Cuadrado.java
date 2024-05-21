package ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

class Cuadrado {

    private ImageView forma;
    private double posX;
    private double posY;

    public Cuadrado(double posX, double posY, double lado, String imagePath) {
        this.posX = posX;
        this.posY = posY;
        this.forma = new ImageView(new Image(new File(imagePath).toURI().toString()));
        
        forma.setFitWidth(lado);
        forma.setFitHeight(lado);
        forma.setTranslateX(posX);
        forma.setTranslateY(posY);
    }

    public ImageView getForma() {
        return forma;
    }

    public double getX() {
        return posX;
    }

    public double getY() {
        return posY;
    }

    public void setX(double x) {
        this.posX = x;
        forma.setTranslateX(x);
    }

    public void setY(double y) {
        this.posY = y;
        forma.setTranslateY(y);
    }
}

