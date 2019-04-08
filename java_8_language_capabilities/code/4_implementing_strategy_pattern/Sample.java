import java.util.*;
import java.util.function.Predicate;

public class Sample {
  /*
  //This approach leads to duplication, lacks separation of concern.

  public static void totalAssets(List<Asset> assets) {
    int total = 0;
    for(Asset asset : assets) {
      total += asset.value;
    }
    System.out.println(total);
  }

  public static void totalStockAssets(List<Asset> assets) {
    int total = 0;
    for(Asset asset : assets) {
      if(asset.type == Asset.AssetType.STOCK)
        total += asset.value;
    }
    System.out.println(total);
  }

  public static void totalBondAssets(List<Asset> assets) {
    int total = 0;
    for(Asset asset : assets) {
      if(asset.type == Asset.AssetType.BOND)
        total += asset.value;
    }
    System.out.println(total);
  }

  */


  public static void totalAssets(List<Asset> assets, Predicate<Asset> selector) {
    System.out.println(
      assets.stream()
      .filter(selector)
      .mapToInt(asset -> asset.value)
      .sum());
  }

  public static void main(String[] args) {
    List<Asset> assets = Arrays.asList(
      new Asset(Asset.AssetType.STOCK, 100),
      new Asset(Asset.AssetType.BOND, 200),
      new Asset(Asset.AssetType.STOCK, 300),
      new Asset(Asset.AssetType.BOND, 400)
    );


    //We don't want to go this route.
    //totalAssets(assets);
    //totalStockAssets(assets);
    //totalBondAssets(assets);

    totalAssets(assets, asset -> true);
    totalAssets(assets, asset -> asset.type == Asset.AssetType.STOCK);
    totalAssets(assets, asset -> asset.type == Asset.AssetType.BOND);
  }
}

