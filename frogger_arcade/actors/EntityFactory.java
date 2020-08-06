package frogger_arcade.actors;



/**
 * @author psymp5
 * EntityFactory is our factory class to create objects, promoting the idea of loose coupling and implementing the Factory Design Pattern
 */
public class EntityFactory  {

    /**
     * Creating variables for switch cases, which will then be used to define which object is being created
     */

    public static final String LOGS_ENTITY = "LOGS";

    public static final String LOG2_ENTITY = "LOG2";

    public static final String LOG3_ENTITY = "LOG3";

    public static final String TURTLE_ENTITY = "TURTLE";

    public static final String WET_TURTLE_ENTITY = "WET_TURTLE";


    /**
     * makeNewEntity allows the GameOne class to call an entity without worrying abouts its structure, and use these parameters instead.
     * @param entityType Allows us to choose which entity we want from a string, so either TURTLE, LOG OR WET_TURTLE
     * @param xStartPos Sets the x position of the entity
     * @param yStartPos Sets the y position of the entity
     * @param entitySpeed Sets the speed of the entity
     * @return The correct entity with its parameters.
     */
            public static Entity makeNewEntity(String entityType, int xStartPos, int yStartPos, double entitySpeed){

                    switch (entityType){
                          case LOGS_ENTITY:
                              return makeLogsEntity(xStartPos, yStartPos, entitySpeed);
                        case LOG2_ENTITY:
                              return  makeLog2Entity(xStartPos, yStartPos, entitySpeed);
                        case LOG3_ENTITY:
                            return  makeLog3Entity(xStartPos, yStartPos, entitySpeed);
                          case  TURTLE_ENTITY:
                              return makeTurtleEntity(xStartPos, yStartPos, entitySpeed);
                          case WET_TURTLE_ENTITY:
                              return makeWetTurtleEntity(xStartPos, yStartPos, entitySpeed);
                                        default:
                                             return null;
                     }
             }

    /**
     * This methods passes the size of the log and sets its image, then allowing us to configure it within main
     * @param xStartPos Sets the x position of the Log
     * @param yStartPos Sets the y position of the Log
     * @param entitySpeed Sets the speed of the Log
     * @return A log object
     */
             private static Entity makeLogsEntity(int xStartPos, int yStartPos, double entitySpeed){
                    return new Log("frogger_arcade/media/Logs/logs.png", 300, xStartPos, yStartPos, entitySpeed);
    }

    /**
     * This methods passes the size of the log and sets its image, then allowing us to configure it within main
     * @param xStartPos Sets the x position of the Log
     * @param yStartPos Sets the y position of the Log
     * @param entitySpeed Sets the speed of the Log
     * @return A log object
     */
    private static Entity makeLog2Entity(int xStartPos, int yStartPos, double entitySpeed){
        return new Log("frogger_arcade/media/Logs/log2.png", 175, xStartPos, yStartPos, entitySpeed);
    }

    /**
     * This methods passes the size of the log and sets its image, then allowing us to configure it within main
     * @param xStartPos Sets the x position of the Log
     * @param yStartPos Sets the y position of the Log
     * @param entitySpeed Sets the speed of the Log
     * @return A log object
     */
    private static Entity makeLog3Entity(int xStartPos, int yStartPos, double entitySpeed){
        return new Log("frogger_arcade/media/Logs/log3.png", 150, xStartPos, yStartPos, entitySpeed);
    }

    /**
     *    This methods passes the size of the Wet Turtle allowing us to configure it within main
     * @param xStartPos Sets the x position of the Turtle
     * @param yStartPos Sets the y position of the Turtle
     * @param entitySpeed Sets the Speed of the Turtle
     * @return
     */

            private static Entity makeTurtleEntity(int xStartPos, int yStartPos, double entitySpeed){
                    return new Turtle(xStartPos, yStartPos, (int)entitySpeed, 130, 130);
    }

    /**
     *    This methods passes the size of the Wet Turtle allowing us to configure it within main
     * @param xStartPos Sets the x position of the Wet Turtle
     * @param yStartPos Sets the y position of the Wet Turtle
     * @param entitySpeed Sets the Speed of the Wet Turtle
     * @return
     */

            private static Entity makeWetTurtleEntity(int xStartPos, int yStartPos, double entitySpeed){
                    return new WetTurtle(xStartPos, yStartPos,(int)entitySpeed, 130, 130);
    }


}
