nerdctl compose -f docker-compose.yml down --remove-orphans
nerdctl compose -f docker-compose.yml up -d
./mvnw package
nerdctl build -f DockerFile-events -t events-service:0.0.1-SNAPSHOT .
nerdctl build -f DockerFile-registration -t registration-service:0.0.1-SNAPSHOT .
nerdctl compose -f docker-compose.yml down --remove-orphans
