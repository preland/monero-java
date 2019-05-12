package monero.wallet;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import monero.daemon.model.MoneroKeyImage;
import monero.daemon.model.MoneroNetworkType;
import monero.rpc.MoneroRpc;
import monero.wallet.model.MoneroAccount;
import monero.wallet.model.MoneroAccountTag;
import monero.wallet.model.MoneroAddressBookEntry;
import monero.wallet.model.MoneroCheckReserve;
import monero.wallet.model.MoneroCheckTx;
import monero.wallet.model.MoneroIntegratedAddress;
import monero.wallet.model.MoneroKeyImageImportResult;
import monero.wallet.model.MoneroOutputWallet;
import monero.wallet.model.MoneroSubaddress;
import monero.wallet.model.MoneroSyncProgressListener;
import monero.wallet.model.MoneroSyncResult;
import monero.wallet.model.MoneroTransfer;
import monero.wallet.model.MoneroTxWallet;
import monero.wallet.request.MoneroOutputRequest;
import monero.wallet.request.MoneroSendRequest;
import monero.wallet.request.MoneroTransferRequest;
import monero.wallet.request.MoneroTxRequest;

/**
 * Implements a Monero wallet using JNI to bridge to Monero core c++.
 */
public class MoneroWalletJni extends MoneroWalletDefault {
  
  // load Monero core c++ as a dynamic library
  static {
    System.loadLibrary("monero-java");
  }
  
  // ---------------------------- WALLET MANAGEMENT ---------------------------
  
  /**
   * Indicates if the wallet at the given path exists.
   * 
   * @param path is the path to check for existence
   * @return true if a wallet exists at the given path, false otherwise
   */
  public static boolean walletExists(String path) {
    return walletExistsJni(path);
  }
  
  /**
   * Open a wallet.
   * 
   * @param path is the path on the filesystem of the wallet to open
   * @param password is the password of the wallet
   * @return the opened wallet
   */
  public static MoneroWalletJni openWallet(String path, String password) {
    return new MoneroWalletJni(openWalletJni(path, password, 0));
  }
  
  /**
   * Create a new randomly generated wallet.
   * 
   * @param path is the path on the filesystem to create the wallet
   * @param password is the password to encrypt the wallet
   * @param networkType is the wallet's network type (default = MoneroNetworkType.MAINNET)
   * @param daemonConnection is connection information to a daemon (default = an unconnected wallet)
   * @param language is the wallet and mnemonic's language (default = "English")
   * @param mnemonic is the mnemonic of a wallet to restore (default = randomly generate a new wallet)
   * @param restoreHeight is the block height to restore (i.e. scan the chain) from (default = 0)
   * @return the created wallet
   */
  public static MoneroWalletJni createWallet(String path, String password, MoneroNetworkType networkType, MoneroRpc daemonConnection, String language) {
    return createWallet(path, password, networkType, daemonConnection, language, null, null);
  }
  
  /**
   * Create a new wallet.
   * 
   * @param path is the path on the filesystem to create the wallet
   * @param password is the password to encrypt the wallet
   * @param networkType is the wallet's network type (default = MoneroNetworkType.MAINNET)
   * @param daemonConnection is connection information to a daemon (default = an unconnected wallet)
   * @param language is the wallet and mnemonic's language (default = "English")
   * @param mnemonic is the mnemonic of a wallet to restore (default = randomly generate a new wallet)
   * @param restoreHeight is the block height to restore (i.e. scan the chain) from (default = 0)
   * @return the created wallet
   */
  public static MoneroWalletJni createWallet(String path, String password, MoneroNetworkType networkType, MoneroRpc daemonConnection, String language, String mnemonic, Integer restoreHeight) {
    throw new RuntimeException("Not implemented");
  }
  
  // ------------------------------- INSTANCE ---------------------------------
  
  private long handle;  // handle to wallet memory address in c++
  
  private MoneroWalletJni(long handle) {
    System.out.println("Internal handle: " + handle);
    this.handle = handle;
  }
  
  private long getHandle() {
    return handle;
  }
  
  // --------------------------- JNI WALLET METHODS ---------------------------
  
  // TODO: comments and other jni specific methods
  
  public String getPath() {
    throw new RuntimeException("Not implemented");
  }
  
  public String getPassword() {
    throw new RuntimeException("Not implemented");
  }
  
  public String getNetworkType() {
    throw new RuntimeException("Not implemented");
  }
  
  public String getLanguage() {
    throw new RuntimeException("Not implemented");
  }
  
  /**
   * Save the wallet.
   */
  public void save() {
    throw new RuntimeException("Not implemented");
  }
  
  /**
   * Close the wallet.
   */
  public void close() {
    throw new RuntimeException("Not implemented");
  }
  
  // -------------------------- COMMON WALLET METHODS -------------------------
  
  public MoneroRpc getDaemonRpc() {
    throw new RuntimeException("Not implemented");
  }
  
  public void setDaemonRpc(MoneroRpc daemonRpc) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getSeed() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getMnemonic() {
    return getMnemonicJni();
  }

  @Override
  public String getPublicViewKey() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getPrivateViewKey() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<String> getLanguages() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public int getHeight() {
    return getHeightJni();
  }

  @Override
  public int getChainHeight() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getPrimaryAddress() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroIntegratedAddress getIntegratedAddress(String paymentId) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroIntegratedAddress decodeIntegratedAddress(String integratedAddress) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroSyncResult sync(Integer startHeight, Integer endHeight, MoneroSyncProgressListener progressListener) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void rescanBlockchain() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean isMultisigImportNeeded() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroAccount> getAccounts(boolean includeSubaddresses, String tag) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroAccount getAccount(int accountIdx, boolean includeSubaddresses) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroAccount createAccount(String label) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroSubaddress> getSubaddresses(int accountIdx, List<Integer> subaddressIndices) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroSubaddress createSubaddress(int accountIdx, String label) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getAddress(int accountIdx, int subaddressIdx) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroSubaddress getAddressIndex(String address) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public BigInteger getBalance() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public BigInteger getBalance(int accountIdx) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public BigInteger getBalance(int accountIdx, int subaddressIdx) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public BigInteger getUnlockedBalance() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public BigInteger getUnlockedBalance(int accountIdx) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public BigInteger getUnlockedBalance(int accountIdx, int subaddressIdx) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroTxWallet> getTxs(MoneroTxRequest request) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroTransfer> getTransfers(MoneroTransferRequest request) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroOutputWallet> getOutputs(MoneroOutputRequest request) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroKeyImage> getKeyImages() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroKeyImageImportResult importKeyImages(List<MoneroKeyImage> keyImages) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroKeyImage> getNewKeyImagesFromLastImport() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroTxWallet send(MoneroSendRequest request) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroTxWallet> sendSplit(MoneroSendRequest request) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroTxWallet sweepOutput(MoneroSendRequest request) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroTxWallet> sweepAllUnlocked(MoneroSendRequest request) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroTxWallet> sweepDust(boolean doNotRelay) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<String> relayTxs(Collection<String> txMetadatas) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<String> getTxNotes(Collection<String> txIds) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void setTxNotes(Collection<String> txIds, Collection<String> notes) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String sign(String msg) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean verify(String msg, String address, String signature) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getTxKey(String txId) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroCheckTx checkTxKey(String txId, String txKey, String address) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getTxProof(String txId, String address, String message) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroCheckTx checkTxProof(String txId, String address, String message, String signature) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getSpendProof(String txId, String message) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public boolean checkSpendProof(String txId, String message, String signature) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getReserveProofWallet(String message) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getReserveProofAccount(int accountIdx, BigInteger amount, String message) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroCheckReserve checkReserveProof(String address, String message, String signature) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroAddressBookEntry> getAddressBookEntries(Collection<Integer> entryIndices) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public int addAddressBookEntry(String address, String description, String paymentId) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void deleteAddressBookEntry(int entryIdx) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void tagAccounts(String tag, Collection<Integer> accountIndices) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void untagAccounts(Collection<Integer> accountIndices) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public List<MoneroAccountTag> getAccountTags() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void setAccountTagLabel(String tag, String label) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String createPaymentUri(MoneroSendRequest request) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public MoneroSendRequest parsePaymentUri(String uri) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getOutputsHex() {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public int importOutputsHex(String outputsHex) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void setAttribute(String key, String val) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public String getAttribute(String key) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void startMining(Integer numThreads, Boolean backgroundMining, Boolean ignoreBattery) {
    throw new RuntimeException("Not implemented");
  }

  @Override
  public void stopMining() {
    throw new RuntimeException("Not implemented");
  }
  
  // ------------------------------ NATIVE METHODS ----------------------------
  
  private native static long openWalletJni(String path, String password, int networkType);
  
  private native static boolean walletExistsJni(String path);
  
  private native int getHeightJni();
  
  private native String getMnemonicJni();
}