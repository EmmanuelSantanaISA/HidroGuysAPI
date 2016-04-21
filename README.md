# HidroGuysAPI
Hidroponic System API

        //Configuracon de la API mediante HidroConfig
        HidroConfig conf = new HidroConfig("localhost", 8080, "HidroGuys/webresources");
        System.out.println("URL: " + conf.getURL());
        //Instancia de la API
        HidroAPI api = new HidroAPI(conf);
        //Lista todas las Farms disponibles en la BD
        List<Farm> farmsList = api.getFarms().getAll();
        for (Farm farm : farmsList) {
            System.out.println("Farm ID: " + farm.getFarmName());
        }
        //Lista todas las Ships disponibles en la BD
        List<Ship> shipsList = api.getShips().getAll();
        for (Ship ship : shipsList) {
            System.out.println("Ship ID: " + ship.getShipName());
        }
        //Lista todas las Lines disponibles en la BD
        List<Line> lineList = api.getLines().getAll();
        for (Line line : lineList) {
            System.out.println("Line Name: " + line.getLineName());
        }
        
        //Obtiene el Farm que contenga el ID '1'
        Farm farm = api.getFarms().get(1);
        System.out.println("ONE FARM: " + farm.getFarmName());
        //Obtiene el Ship que contenga el ID '5'
        Ship ship = api.getShips().get(5);
        System.out.println("ONE SHIP: " + ship.getShipName());
        //Obtiene la Linea que contenga el ID '3'
        Line line = api.getLines().get(3);
        System.out.println("ONE LINE: " + line.getLineName());
