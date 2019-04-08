public class Asset {
  public enum AssetType { STOCK, BOND };

  public final AssetType type;
  public final int value;

  public Asset(AssetType assetType, int assetValue) {
    type = assetType;
    value = assetValue;
  }
}