package PARCIALES.P2.P220222C.ej2;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultilingualDictionary {
    private Map<Language, Map<String, String>> map = new EnumMap<>(Language.class);
    private Language base;

    MultilingualDictionary(Language base){
        this.base = base;
    }

    public MultilingualDictionary addTranslation(String baseDef, Language newLan, String newDef) {
        if(base.equals(newLan)){
            throw new IllegalArgumentException("Cannot add %s translations".formatted(newLan));
        }
        map.putIfAbsent(newLan, new HashMap<>());
        map.get(newLan).putIfAbsent(baseDef, newDef);
        return this;
    }

    public String getTranslation(String baseDef, Language otherLan){
        if(! map.containsKey(otherLan) || !map.get(otherLan).containsKey(baseDef)){
            throw new IllegalArgumentException("No %s translation for %s".formatted(otherLan, baseDef));
        }
        return map.get(otherLan).get(baseDef);
    }

    public int translationsCount(Language l){
        return map.getOrDefault(l, new HashMap<>()).size();
    }

    public int removeTranslations(Language l){
        int toReturn = translationsCount(l);
        map.remove(l);
        return toReturn;
    }


}
