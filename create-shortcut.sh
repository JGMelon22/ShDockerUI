# Download program icon
cd ~/
wget https://raw.githubusercontent.com/JGMelon22/ShDockerUI/main/src/assets/logo.png

# Create desktop icon
cd ~/.local/share/applications
touch ShDockerUI.desktop
echo [Desktop Entry] >> ShDockerUI.desktop
echo Encoding=UTF-8 >> ShDockerUI.desktop
echo Name=ShDockerUI >> ShDockerUI.desktop
echo Path=~/ >> ShDockerUI.desktop
echo Exec=java -jar ~/ShDockerUI.jar >> ShDockerUI.desktop
echo Terminal=false >> ShDockerUI.desktop
echo Type=Application >> ShDockerUI.desktop
echo Categories=Development >> ShDockerUI.desktop
echo Comment=Easily start and stop docker containers >> ShDockerUI.desktop
echo Icon=~/logo.png >> ShDockerUI.desktop

# Operation finished successfully
echo "Shortcut successfully created!"
