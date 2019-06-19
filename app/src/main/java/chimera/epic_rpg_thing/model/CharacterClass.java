package chimera.epic_rpg_thing.model;

import java.util.HashMap;

import chimera.epic_rpg_thing.model.Skill;

public abstract class CharacterClass {
    // HashMap of the class modifiers
    private String className;
    private HashMap<String, Integer> classMods;
    // Level of the class
    private int classLevel;
    // HashMap of the class skills
    private HashMap<String, Skill> classSkills;

    /**
     * Gets the class name
     * @return
     */
    public String getName(){
        return className;
    }

    /**
     * Sets the class name
     * @param name
     */
    public void setName(String name){
        className = name;
    }
    /**
     * Get's the classMod from the classMods HashMap given a key
     * @return int
     */
    public int getClassMod(String key){
        return classMods.get(key);
    }
    /**
     * puts mod to the classMods HashMap key
     * @param key
     * @param mod
     */
    public void addClassMod(String key, int mod){
        classMods.put(key, mod);
    }
    /**
     * Sets classSkills given a HashMap set
     * @param set
     */
    public void setClassSkills(HashMap<String,Skill> set){
        classSkills = set;
    }
    /**
     * Gets a classSkill through the HashSet<Skill> classSkills
     * @param skillName
     */
    public Skill getClassSkill(String skillName){
        return classSkills.get(skillName);
    }
}
