# Nukkit-MOT UUID Patch

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

If your plugins store data by UUID, a player playing without an Xbox may lose their data because their UUID may change when reinstalling the game, changing devices, or other reasons.

This project was created to fix changing the player's UUID when logging in without an Xbox account.

## 📖 What this patch does
1. Gets the UUID saved in the player's NBT, if it is not found, uses the UUID passed by the client at login on the server and saves it in the NBT.
2. Adds EntityHuman#getLoginUuid() method to get the UUID provided by the client at login.
3. Uses in packets (e.g. PlayerListPacket or AddPlayerPacket) the UUID received using the EntityHuman#getLoginUuid() method.

## 🚀 How to use
1. Clone the repository with patches:
```bash
git clone https://github.com/LuminiaBedrock/Nukkit-MOT-UUID-Patch.git
```
2. Navigate to the Nukkit-MOT-UUID-Patch directory:
```bash
cd Nukkit-MOT-UUID-Patch
```
3. Clone the Nukkit-MOT repository:
```bash
git clone https://github.com/MemoriesOfTime/Nukkit-MOT.git
```
4. Apply the patches using the command:
```bash
./gradlew applyChanges
```
**Now you can build the Nukkit-MOT and it will be ready for use!**

## 📄 Take note
These patches will work on any Nukkit-MOT, as long as there are no major changes with the modified fragments.

If the patches do not work or are not applied correctly, create a [new issue](https://github.com/LuminiaBedrock/Nukkit-MOT-UUID-Patch/issues/new) with a description of the problem.