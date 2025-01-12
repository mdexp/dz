public class ImgThread extends Thread{
     MyImage myImage;
    private int imgStep = 91;

    ImgThread(MyImage myImage){
        this.myImage=myImage;
    }
    public void run(){
        for(int i=0;true;i++){
            if(i==8){
                i=0;
                myImage.x=0;
            }
            myImage.x -= imgStep;
            myImage.repaint();
            try{
                Thread.sleep(1000/7);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
}
