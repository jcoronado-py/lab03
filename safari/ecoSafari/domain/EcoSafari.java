package domain;


public class EcoSafari{
 
    private static final int SIZE=25;
    private Entity[][] cells;
    
    /**
     * Constructs a new EcoSafari
     */
    public EcoSafari() {
        cells=new Entity[SIZE][SIZE];
        someEntities();
    }

    /**
     * Pupulates the EcoSafari with some entities
     */
    public void someEntities(){
        //Ciclo 1
        //Elephant dumbo = new Elephant(this, 5, 5);
        //Elephant babar = new Elephant(this, 10, 10);
     
        //Ciclo 2
        //Arbusto mopane = new Arbusto(this, 11, 10);
        //Arbusto acacia = new Arbusto(this, 12, 10);
     
        //Ciclo 3
        //Storm thor = new Storm(this, 0, 0);
        //Storm tempest = new Storm(this, 5, 0);
        
        //Ciclo 4
        //babyElephant Coronado = new babyElephant(this, 0, 0);
        //babyElephant Horta = new babyElephant(this, 5, 0);
        
        //Ciclo 5
        //Roca Coronado = new Roca(this, 0, 0);
        //Roca Horta = new Roca(this, 5, 0);
     
     
        // Zona 1: cebra + leon
        Tierra t1 = new Tierra(this, 10, 10);
        Tierra t2 = new Tierra(this, 10, 11);
        Tierra t3 = new Tierra(this, 10, 12);
        Tierra t4 = new Tierra(this, 11, 10);
        Tierra t5 = new Tierra(this, 11, 12);
        Tierra t6 = new Tierra(this, 12, 10);
        Tierra t7 = new Tierra(this, 12, 11);
        Tierra t8 = new Tierra(this, 12, 12);
     
        //Pasto pasto1 = new Pasto(this, 9, 10);
        //Cebra cebra1 = new Cebra(this, 11, 11);
        //Leon leon1 = new Leon(this, 13, 11);
     
        // Zona 2: otra pareja cebra + leon
        Tierra t9 = new Tierra(this, 15, 15);
        Tierra t10 = new Tierra(this, 15, 16);
        Tierra t11 = new Tierra(this, 15, 17);
        Tierra t12 = new Tierra(this, 16, 15);
        Tierra t13 = new Tierra(this, 16, 17);
        Tierra t14 = new Tierra(this, 17, 15);
        Tierra t15 = new Tierra(this, 17, 16);
        Tierra t16 = new Tierra(this, 17, 17);
     
        Pasto pasto2 = new Pasto(this, 14, 16);
        Cebra cebra2 = new Cebra(this, 16, 16);
        Leon leon2 = new Leon(this, 18, 16);
     
        // Cebras adicionales sueltas (sin leon cerca) para observar reproduccion
        Tierra t17 = new Tierra(this, 20, 10);
        Tierra t18 = new Tierra(this, 20, 11);
        Tierra t19 = new Tierra(this, 20, 12);
        Cebra cebra3 = new Cebra(this, 20, 10);
        Cebra cebra4 = new Cebra(this, 20, 12);
    }
    
    /**
     * Returns the size of the EcoSafari 
     * @return 
     */
    public int  getSize(){
        return SIZE;
    }

    /**
     * Determines whether a position is inside the EcoSafari
     * @param r the row
     * @param c the column
     * @return 
     */
    public boolean isInside(int r, int c){
        return ((0<=r) && (r<SIZE) && (0<=c) && (c<SIZE));
    }
    
    /**
     * Returns the entity located at a specified position
     * @param r the row
     * @param c the column
     * @return 
     */
    public Entity get(int r,int c){
        return (isInside(r,c)? cells[r][c]: null);
    }

    /**
     * Places an entity at a specified position
     * @param r the row
     * @param c the column
     */
    public void set(Entity e, int r, int c){
        if (isInside(r,c)){ 
            cells[r][c]=e;
        }
    }

    
    /**
     * Finds the position of a specified entity
     * @param e the entity
     * @return an array {row, column} if the entity is found. null otherwise
     */
    public int[]  find(Entity e){
       int[] position=null;
       for (int r=0 ; r<SIZE && position== null; r++){
           for (int c=0 ; c<SIZE && position==null ;c++){
               if (cells[r][c]==e){
                   position=new int [] {r,c};
               }
           }
       }
       return position;
    }
    
 
    /**
     * Advances the simulation by one time step
     */
    //First, all entities execute their tic() action
    //Then, all entities execute their tac() actions
    public void ticTac(){  
        for(int i = 0; i<SIZE; i++){
            for(int j =0; j<SIZE; j++){
                if(cells[i][j]!=null){
                    cells[i][j].tic();
                }
            }
        }    
            
        for(int i = 0; i<SIZE; i++){
            for(int j =0; j<SIZE; j++){
                if(cells[i][j]!=null){
                    cells[i][j].tac();
                }
            }
            
        }
    }

}
