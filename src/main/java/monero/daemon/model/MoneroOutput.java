package monero.daemon.model;

import java.math.BigInteger;
import java.util.List;

import monero.utils.MoneroUtils;

/**
 * Represents a transaction output.
 */
public class MoneroOutput {

  private MoneroTx tx;
  private MoneroKeyImage keyImage;
  private BigInteger amount;
  private Integer index;
  private List<Integer> ringOutputIndices;
  private String stealthPublicKey;
  
  public MoneroTx getTx() {
    return tx;
  }
  
  public MoneroOutput setTx(MoneroTx tx) {
    this.tx = tx;
    return this;
  }
  
  public MoneroKeyImage getKeyImage() {
    return keyImage;
  }
  
  public MoneroOutput setKeyImage(MoneroKeyImage keyImage) {
    this.keyImage = keyImage;
    return this;
  }
  
  public BigInteger getAmount() {
    return amount;
  }
  
  public MoneroOutput setAmount(BigInteger amount) {
    this.amount = amount;
    return this;
  }
  
  public Integer getIndex() {
    return index;
  }
  
  public MoneroOutput setIndex(Integer index) {
    this.index = index;
    return this;
  }
  
  public List<Integer> getRingOutputIndices() {
    return ringOutputIndices;
  }
  
  public MoneroOutput setRingOutputIndices(List<Integer> ringOutputIndices) {
    this.ringOutputIndices = ringOutputIndices;
    return this;
  }
  
  public String getStealthPublicKey() {
    return stealthPublicKey;
  }
  
  public MoneroOutput setStealthPublicKey(String stealthPublicKey) {
    this.stealthPublicKey = stealthPublicKey;
    return this;
  }
  
  public String toString() {
    return toString(0);
  }
  
  public String toString(int indent) {
    StringBuilder sb = new StringBuilder();
    if (getKeyImage() != null) {
      sb.append(MoneroUtils.kvLine("Key image", "", indent));
      sb.append(getKeyImage().toString(indent + 1) + "\n");
    }
    sb.append(MoneroUtils.kvLine("Amount", getAmount(), indent));
    sb.append(MoneroUtils.kvLine("Index", getIndex(), indent));
    sb.append(MoneroUtils.kvLine("Ring output indices", getRingOutputIndices(), indent));
    String str = sb.toString();
    return str.substring(0, str.length() - 1);  // strip newline
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((index == null) ? 0 : index.hashCode());
    result = prime * result + ((keyImage == null) ? 0 : keyImage.hashCode());
    result = prime * result + ((ringOutputIndices == null) ? 0 : ringOutputIndices.hashCode());
    result = prime * result + ((stealthPublicKey == null) ? 0 : stealthPublicKey.hashCode());
    result = prime * result + ((tx == null) ? 0 : tx.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    MoneroOutput other = (MoneroOutput) obj;
    if (amount == null) {
      if (other.amount != null) return false;
    } else if (!amount.equals(other.amount)) return false;
    if (index == null) {
      if (other.index != null) return false;
    } else if (!index.equals(other.index)) return false;
    if (keyImage == null) {
      if (other.keyImage != null) return false;
    } else if (!keyImage.equals(other.keyImage)) return false;
    if (ringOutputIndices == null) {
      if (other.ringOutputIndices != null) return false;
    } else if (!ringOutputIndices.equals(other.ringOutputIndices)) return false;
    if (stealthPublicKey == null) {
      if (other.stealthPublicKey != null) return false;
    } else if (!stealthPublicKey.equals(other.stealthPublicKey)) return false;
    if (tx == null) {
      if (other.tx != null) return false;
    } else if (!tx.equals(other.tx)) return false;
    return true;
  }
}