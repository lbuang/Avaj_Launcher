find -name *.java > sources.txt
javac -sourcepath . @sources.txt
cd src/
echo "$(tput setaf 2)Hi there, Classes have been created successfully!"
echo "$(tput setaf 1)"
java start.tower.Simulator scenario.txt

  echo $(tput setaf 2)
  cat simulator.txt;
cd ..