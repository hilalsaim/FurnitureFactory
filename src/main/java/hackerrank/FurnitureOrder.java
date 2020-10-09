package hackerrank;

import java.util.HashMap;
import java.util.Map.Entry;

public class FurnitureOrder implements FurnitureOrderInterface {
    HashMap<Furniture, Integer> order;
    
    FurnitureOrder() {
       order = new HashMap<Furniture, Integer>();
       for(Furniture furniture : Furniture.values()) {
    	   order.put(furniture, 0);
       }
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
    	order.put(type, order.get(type) + furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        return order;
    }

    public float getTotalOrderCost() {
    	float totalOrderCost = 0.0f;
    	for (Entry<Furniture, Integer> entry : order.entrySet()) {
    		totalOrderCost += entry.getKey().cost() * entry.getValue();
    	}
        return totalOrderCost;
    }

    public int getTypeCount(Furniture type) {
        return order.get(type);
    }

    public float getTypeCost(Furniture type) {
        return order.get(type) * type.cost();
    }

    public int getTotalOrderQuantity() {
    	return order.values().stream().reduce(0, Integer::sum);
    }
}