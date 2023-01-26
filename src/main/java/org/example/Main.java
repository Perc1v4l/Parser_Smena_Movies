package org.example;
import ParserSmena.*;
import ParserSmena.model_2.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException{
        Worker<ArrayList<String>> parser = new Worker<>(new Parser2());
        parser.setParserSettings(new Settings());
        parser.onCompletedList.add(new Completed());
        parser.onNewDataList.add(new NewData());

        parser.Start();
        Thread.sleep(10000);
        parser.Abort();
    }

    static class NewData implements OnNewData<Head> {

        @Override
        public void OnNewData(Object sender,Head list) {
            for(Date date: list.getDates())
            {
                System.out.println("------------------"+date.getDate()+"------------------");
                for(Movie movie: date.getMovies())
                {
                    System.out.println("\t\t\t\t" + movie.getName());
                    outImage(movie.getImageURL(), movie.getName());
                    for(Cinema cinema:movie.getCinemas())
                    {
                        System.out.println("Кинотеатр: " + cinema.getName() + "\tпо адресу " + cinema.getAddress());
                        for(int i=0;i<cinema.getSeanses().size();i++)
                        {
                            Seans seans = cinema.getSeanses().get(i);
                            if(i%2==0 && i!=0) System.out.printf("\nНачало: "+ seans.getTime() + " Цена: " + seans.getCost() + "\t");
                            else System.out.printf("Начало: "+ seans.getTime() + " Цена: " + seans.getCost() + "\t");
                        }
                        System.out.println("\n");
                    }
                    System.out.println();
                }
            }
        }
        public void outImage(String imageSRC, String imageName){
            BufferedImage bufferedImage = null;
            URL imageURL = null;
            try{
                imageURL = new URL(imageSRC);
            } catch (MalformedURLException e) {
                return;
                //unreliable url
            }
            try {
                bufferedImage = ImageIO.read(imageURL);
            } catch (IOException e) {
                //throw new RuntimeException(e);
                return;
            }
            if (bufferedImage==null)
                return;

            File outputfile = new File("src/pictures/" + imageName + ".jpeg");

            try {
                ImageIO.write(bufferedImage, "jpeg", outputfile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    static class Completed implements OnCompleted {
        @Override
        public void OnCompleted(Object sender) {
            System.out.println("Загрузка закончена");
        }
    }
}