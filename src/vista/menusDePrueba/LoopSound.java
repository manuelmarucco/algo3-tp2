package vista.menusDePrueba;


import vista.sonido.Sound;

public class LoopSound {

    public static void main(String[] args) throws Exception {
        /*
        File soundFile = new File("sounds/soundtrack.wav");
        Clip clip = AudioSystem.getClip();
        // getAudioInputStream() also accepts a File or InputStream
        AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);

        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
       // clip.start();
        while(true);
        /*
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // A GUI element to prevent the Clip's daemon Thread
                // from terminating at the end of the main()
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });

*/
       // Sound soundtrack = new Sound("sounds/soundtrack.wav");
        Sound soundtrack = new Sound("sounds/construcciones/destruccionEdificio.wav");

       // soundtrack.playLoop();
        soundtrack.playSingleTime();

        while(true);
    }
}