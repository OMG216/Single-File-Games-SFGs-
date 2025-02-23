public class Pointer{
    private int x,y,xll,yll,xml,yml;
    Pointer(int xll,int yll,int xml,int yml){
        this.xll = xll;
        this.yll = yll;
        this.xml = xml;
        this.yml = yml;
        this.x = xll;
        this.y = yll;
    }
    public void setPoint(int x,int y){
        if(x < xll || x > xml || y < yll || y > yml){
            throw new ArrayIndexOutOfBoundsException("The pointer is out of Bounds");
        }
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
    public void next(){
        if(x < xml){
            x++;
        }
        else{
            x = xll;
            if(y < yml){
                y++;
            }
            else{
                y = yll;
            }
        }
    }

    public void previos(){
        if(x > xll){
            x--;
        }
        else{
            x = xml;
            if(y > yll){
                y--;
            }
            else{
                y = yml;
            }
        }
    }

}