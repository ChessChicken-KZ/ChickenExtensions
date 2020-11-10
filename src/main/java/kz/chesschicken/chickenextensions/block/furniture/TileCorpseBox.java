package kz.chesschicken.chickenextensions.block.furniture;

public class TileCorpseBox extends TileEntityExtended{

    public TileCorpseBox() {
        super();
    }

    @Override
    public int getInventorySize() {
        return 45;
    }



    @Override
    public String getContainerName() {
        return "Corpse Box";
    }



}
