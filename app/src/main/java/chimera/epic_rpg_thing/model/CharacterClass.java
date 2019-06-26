package chimera.epic_rpg_thing.model;

import java.util.HashMap;
import java.util.List;

public abstract class CharacterClass {
    // HashMap of the class modifiers
    String className;
    HashMap<String, Integer> classMods = new HashMap<>();
    // Level of the class
    int classLevel;
    // HashMap of the class baseSkills
    HashMap<String, BaseSkill> classSkills = new HashMap<>();
    List<ElementalEffect> weaknesses;

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
    public void setClassSkills(HashMap<String, BaseSkill> set){
        classSkills = set;
    }
    /**
     * Gets a classSkill through the HashSet<BaseSkill> classSkills
     * @param skillName
     */
    public BaseSkill getClassSkill(String skillName){
        return classSkills.get(skillName);
    }

    /**
     * Gets the list of weaknesses
     * @return
     */
    public List<ElementalEffect> getWeaknesses(){
        return weaknesses;
    }

    /**
     * Sets the list of weaknesses
     * @param weaknesses
     */
    public void setWeaknesses(List<ElementalEffect> weaknesses){
        this.weaknesses = weaknesses;
    }

    /**
     * Adds an weakness to the list of weaknesses
     * @param weakness
     */
    public void addWeaknesses(ElementalEffect weakness){
        this.weaknesses.add(weakness);
    }

    /**
     * Remove a weakness to the list of weaknesses
     * @param weakness
     */
    public void removeWeakness(ElementalEffect weakness){
        if(weaknesses.contains(weakness)){
            weaknesses.remove(weakness);
        }
    }
}
