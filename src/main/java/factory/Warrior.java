package main.java.factory;

import java.util.Random;

public class Warrior extends Bee {

    // Stat constants
    private static final int DEFAULT_ATTACK = 20;
    private static final int DEFAULT_HEALTH = 20;
    private static final int DEFAULT_STAMINA = 15;
    private static final int BONUS_ATTACK = 4;
    private static final int BONUS_HEALTH = 4;
    private static final int BONUS_STAMINA = 3;
    
    private Random rdm = new Random();
    
    /**
     * Warrior sub-class of Bee class.
     * 
     * @param inputId Integer, id to set on bee
     * @param inputHiveId Integer, hiveId to set on bee
     * @param inputSpecies BeeSpecies, species to set on bee
     */
    public Warrior(int inputId, int inputHiveId, BeeSpeciesF inputSpecies) {
        // Set bee information
        this.id = inputId;
        this.beeHiveId = inputHiveId;
        this.species = inputSpecies;
        this.currentState = BeeState.Nothing;
        
        // Initialize bonus
        int bonusAttack = 0;
        int bonusHealth = 0;
        int bonusStamina = 0;
        
        // Set bonus based on species
        if (species == BeeSpeciesF.Killer) {
            bonusAttack = BONUS_ATTACK;
            bonusStamina = -BONUS_STAMINA;
        } else if (species == BeeSpeciesF.Carpenter) {
            bonusHealth = -BONUS_HEALTH;
            bonusStamina = BONUS_STAMINA;
        } else if (species == BeeSpeciesF.Bumble) {
            bonusAttack = -BONUS_ATTACK;
            bonusHealth = BONUS_HEALTH;
        } else if (species == BeeSpeciesF.Tiny) {
            bonusAttack = -BONUS_ATTACK;
            bonusHealth = -BONUS_HEALTH;
            bonusStamina = -BONUS_STAMINA;
        } else if (species == BeeSpeciesF.Super) {
            bonusAttack = BONUS_ATTACK;
            bonusHealth = BONUS_HEALTH;
            bonusStamina = BONUS_STAMINA;
        }
        
        // Set stats based on bonus
        this.attack = DEFAULT_ATTACK + bonusAttack;
        this.healthMax = DEFAULT_HEALTH + bonusHealth;
        this.health = this.healthMax;
        this.staminaMax = DEFAULT_STAMINA + bonusStamina;
        this.stamina = this.staminaMax;
    }

    @Override
    public void setState(BeeState input) {
        if (input == BeeState.Nothing || input == BeeState.Search || input == BeeState.Attack 
                || input == BeeState.Return || input == BeeState.Rest) {
            this.currentState = input;
        }
    }

    @Override
    public String doAction() {
        String output = "Nothing";
        
        // Actions done based on current state
        if (currentState == BeeState.Nothing) {
            currentState = BeeState.Search;
        } else if (currentState == BeeState.Search) {
            stamina = stamina - 1;
            output = "search";
            if (stamina == 0) {
                currentState = BeeState.Return;
            } else {
                if (rdm.nextBoolean()) {
                    currentState = BeeState.Attack;
                }
            }
        } else if (currentState == BeeState.Attack) {
            stamina = stamina - 1;
            output = "attack";
            // If not out of stamina then search again
            if (stamina == 0) {
                currentState = BeeState.Return;
            } else {
                currentState = BeeState.Search;
            }
        } else if (currentState == BeeState.Return) {
            output = "return";
            currentState = BeeState.Rest;
        } else if (currentState == BeeState.Rest) {
            stamina = staminaMax;
            currentState = BeeState.Search;
            output = "-food";
        } 
        
        return output;
    }

    @Override
    public String getType() {
        return "Warrior";
    }

}
