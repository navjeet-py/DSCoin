# DS Coin


### Concepts used in the implementation - 
1. Merkle Tree
2. Hashing 
3. Blockchains
4. Mining
5. Various others algorithms and data structures 

### Languages used - 
1. JAVA 11

### Basic Details
In this project, I built a cryptocurrency model, DSCoin. Every DSCoin has a unique serial number. Whenever person A wants to send a coin to person B, A makes contact with the moderator with the transaction details. Moderator verifies all the details and finalises the transaction. One can also mine coins and get rewarded for it. All kinds of security measures of a typical cryptocurrencies are followed. 

All the project details can be found in this pdf - [Project Details](https://github.com/navjeet-py/DSCoin/blob/main/Project%20Details.pdf).

Example transactions can be found in this pdf - [Transaction Examples](https://github.com/navjeet-py/DSCoin/blob/main/Transaction%20Example.pdf).

### Basic Conventions and Terminoloies - 
1. Every coin is a six digit unique number.
2. Every transaction has the following information:
   * the coin being transferred
   * the source (that is, the person spending this coin)
   * the destination (that is, the person receiving this coin)
   * some information to indicate when the source received this coin from someone (this will be described in more detail later).
 For simplicity, we assume every transaction consists of exactly one coin.
3. A transaction-block consists of a set of transactions. Let *tr-count* denote the number of transactions per block. The transaction-block will also have additional attributes, which will be discussed below.
4. A *blockchain* is an authenticated linked list of transaction-blocks.
5. **Pending transactions and transaction-queue:** All the transactions in the transaction-block are processed transactions. Additionally, we have a transaction-queue which contains pending transactions. Every new transaction is first added to the transaction-queue, and later moved to a transaction-block (and thus added to the blockchain).

![](https://user-images.githubusercontent.com/67374125/186255343-b894af6b-d8fe-4153-90d6-e4ff7fa425db.jpeg)
