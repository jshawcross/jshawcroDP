package main.java.builder;

public class BeeHive {
    
    /**
     * @author user
     *
     */
    private static enum BeeType {
        Honey, Killer, Carpenter, Bumble, Tiny, Super;
    }
    
    private static final int FOODPERROOM = 10;
    private static final int EGGSPERROOM = 2;
    private static final int RESTPERROOM = 6;
    
    // Required parameters
    private int id;
    private int locationX;
    private int locationY;
        
    // Optional parameters
    private BeeType type;
    private int foodAmount;
    private int eggAmount;
    private int roomAmount;
    private int workRequired;
    
    // Depends on number of rooms
    private int foodCapacity;
    private int eggCapacity;
    private int restCapacity;
    
    // Depends on Bee type
    private int foodModifier;
    private int eggModifier;
    private int restModifier;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return the xAxisLoc
     */
    public int getLocationX() {
        return locationX;
    }

    /**
     * @return the yAxisLoc
     */
    public int getLocationY() {
        return locationY;
    }

    /**
     * @return the type
     */
    public BeeType getType() {
        return type;
    }
    
    /**
     * @return the foodAmount
     */
    public int getFoodAmount() {
        return foodAmount;
    }
    
    /**
     * @return the eggAmount
     */
    public int getEggAmount() {
        return eggAmount;
    }
    
    /**
     * @return the roomAmount
     */
    public int getRoomAmount() {
        return roomAmount;
    }
    
    /**
     * @return the workRequired
     */
    public int getWorkRequired() {
        return workRequired;
    }
    
    /**
     * @return the foodCapacity
     */
    public int getFoodCapacity() {
        return foodCapacity;
    }
    
    /**
     * @return the eggCapacity
     */
    public int getEggCapacity() {
        return eggCapacity;
    }
    
    /**
     * @return the restCapacity
     */
    public int getRestCapacity() {
        return restCapacity;
    }
    
    /**
     * @return the foodModifier
     */
    public int getFoodModifier() {
        return foodModifier;
    }
    
    /**
     * @return the eggModifier
     */
    public int getEggModifier() {
        return eggModifier;
    }
    
    /**
     * @return the restModifier
     */
    public int getRestModifier() {
        return restModifier;
    }
    
    /**
     * Private constructor called from builder class to create BeeHive object.
     * 
     * @param builder BeeHiveBuilder, Builder object created for parameter
     */
    private BeeHive(BeeHiveBuilder builder) {
        this.id = builder.id;
        this.locationX = builder.locationX;
        this.locationY = builder.locationY;
        this.type = builder.type;
        this.foodAmount = builder.foodAmount;
        this.eggAmount = builder.eggAmount;
        this.roomAmount = builder.roomAmount;
        this.workRequired = builder.workRequired;
        this.foodCapacity = builder.foodCapacity;
        this.eggCapacity = builder.eggCapacity;
        this.restCapacity = builder.restCapacity;
        this.foodModifier = builder.foodModifier;
        this.eggModifier = builder.eggModifier;
        this.restModifier = builder.restModifier;
    }
    
    /**
     * Builder class for BeeHive class.
     * 
     * @author Jason Shawcross
     *
     */
    public static class BeeHiveBuilder {
        // Required parameters
        private int id;
        private int locationX;
        private int locationY;
            
        // Optional parameters
        private BeeType type;
        private int foodAmount;
        private int eggAmount;
        private int roomAmount;
        private int workRequired;
        
        // Depends on number of rooms
        private int foodCapacity;
        private int eggCapacity;
        private int restCapacity;
        
        // Depends on Bee type
        private int foodModifier;
        private int eggModifier;
        private int restModifier;
        
        /**
         * Constructor used to create default BeeHiveBuilder object.
         * 
         * @param inputId Integer, Id passed as parameter
         * @param inputX Integer, X axis location passed as parameter
         * @param inputY Integer, Y axis location passed as parameter
         */
        public BeeHiveBuilder(int inputId, int inputX, int inputY) {
            // Required parameters
            this.id = inputId;
            this.locationX = inputX;
            this.locationY = inputY;
            
            // Default parameters
            this.type = BeeType.Honey;
            this.foodAmount = 10;
            this.eggAmount = 0;
            this.roomAmount = 3;
            this.workRequired = 100;
            this.foodModifier = 0;
            this.eggModifier = 0;
            this.restModifier = 0;
            
            updateCapacity();
        }
        
        /**
         * @param inputType
         * @return
         */
        public BeeHiveBuilder setType(BeeType inputType) {
            this.type = inputType;
            
            if (inputType == BeeType.Killer) {
                this.restCapacity = 2;
            } else if (inputType == BeeType.Carpenter) {
                this.foodCapacity = 3;
            } else if (inputType == BeeType.Bumble) {
                this.eggModifier = 1;
            } else if (inputType == BeeType.Tiny) {
                this.foodModifier = -3;
                this.eggModifier = -1;
                this.restModifier = 2;
            } else if (inputType == BeeType.Super) {
                this.foodModifier = 2;
                this.eggModifier = 1;
                this.restModifier = 1;
            } else {
                this.foodModifier = 0;
                this.eggModifier = 0;
                this.restModifier = 0;
            }
            
            updateCapacity();
            
            return this;
        }
        
        /**
         * @param inputFood
         * @return
         */
        public BeeHiveBuilder setFoodAmount(int inputFood) {
            this.foodAmount = inputFood;
            return this;
        }
        
        /**
         * @param inputEgg
         * @return
         */
        public BeeHiveBuilder setEggAmount(int inputEgg) {
            this.eggAmount = inputEgg;
            return this;
        }
        
        /**
         * @param inputRoom
         * @return
         */
        public BeeHiveBuilder setRoomAmount(int inputRoom) {
            this.roomAmount = inputRoom;
            return this;
        }
        
        /**
         * @param inputWork
         * @return
         */
        public BeeHiveBuilder setWorkRequired(int inputWork) {
            this.workRequired = inputWork;
            return this;
        }
        
        /**
         * @return
         */
        public BeeHive build() {
            return new BeeHive(this);
        }
        
        /**
         *  Method to update the capacity values in case either the modifiers
         *  or the room amount is changed from default.
         */
        private void updateCapacity() {
            this.foodCapacity = (FOODPERROOM + this.foodModifier) * this.roomAmount;
            this.eggCapacity = (EGGSPERROOM + this.eggModifier) * this.roomAmount;
            this.restCapacity = (RESTPERROOM + this.restModifier) * this.roomAmount;
        }
    }
}
