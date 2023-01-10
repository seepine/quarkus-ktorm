run(){
  echo "[RUN] " $*
  $*
  if [ $? -ne 0 ] ;then
      echo "[ERROR] fail"
      exit 1
  fi
}

# build
NAME=$(cat gradle.properties  | grep "projectName"| sed 's/projectName//g' | sed 's/=//g')
VERSION=$(cat gradle.properties  | grep "projectVersion"| sed 's/projectVersion//g' | sed 's/=//g')
HUB=$(cat gradle.properties  | grep "projectHub"| sed 's/projectHub//g' | sed 's/=//g')

run docker build -f src/main/docker/Dockerfile.multistage -t ${HUB}/${NAME}:${VERSION} .
run docker run -i --rm -p 8080:8080 ${HUB}/${NAME}:${VERSION}
