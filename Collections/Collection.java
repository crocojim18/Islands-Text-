/* Collection.java
 * Collections in general are arrangements of other items
 * that can be easily inserted into the map en masse.
 * Generally used for buildings.
*/

package Collections;

import Items.PhysObject;
import Terrains.Terrain;

public abstract class Collection
{
    PhysObject[][] arr;	//items in the collection
    Terrain[][] arr2;	//mirror of the PhysObject array holding the Terrains underneath
    int h;				//size on x-axis
    int l;				//size on y-axis
	
	/* method getArr()
     * ARGUMENTS:   NONE
     * RETURNS:     PhysObject[][]
     * The returned double-array holds the items in their configuration.
     */
    public PhysObject[][] getArr()
    {
        return arr;
    }
	
	/* method getLength()
     * ARGUMENTS:   NONE
     * RETURNS:     int
     * Gives the length across the x-axis
     */
    public int getLength()
    {
        return l;
    }
	
	/* method getHeight()
     * ARGUMENTS:   NONE
     * RETURNS:     int
     * Gives the length across the y-axis
     */
    public int getHeight()
    {
        return h;
    }
	
	/* method getTerrArr()
     * ARGUMENTS:   NONE
     * RETURNS:     Terrain[][]
     * Returns the double-array of the terrains under the collection.
     */
    public Terrain[][] getTerrArr()
    {
        return arr2;
    }
}