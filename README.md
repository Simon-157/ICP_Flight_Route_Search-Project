
# Flight Route Searching With A*Search and Breadth First Search

This is program that takes in a start position on any part of the earth geographical area and searches for an optimal path to a given destination in the globe through flight with distance optimality( for A*) and number of flights( for BFS)


## Running Tests/Demo
All you need is an iput file with the ## start city and country and the ## destination city and country .
To run tests, run the following command, 
* Change the parameter of the constructor of the test1 object to the name
the file of the input file. or 
* create an object of the PathFinder class and
* pass the name of the input file as a parameter to the constructor
* to get the optimal path, call the optimalPathSearchByAstar method on the object of the PathFinder
* to get a valid path, call the breadthFirstSearch method on the object PathFinder.
* Make sure the Input file is present in the current directory, i.e cd flight-route-finding 

```bash
     public static void main(String[] args) {
        PathFinder test1 = new PathFinder("accra-winnepeg.txt");
        test1.readInputFile();
        try {
            test1.getStartEndAirport();
            test1.optimalPathSearchByAstar();
           // test1.breadthFirstSearch();
           
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
```



## Run Locally

Clone the project

```bash
  git clone https://github.com/Simon-157/ICP_Flight_Route_Search-Project.git
```

Go to the project directory

```bash
  cd flight-route-finding
```

Install dependencies

```bash
  no dependcies to be installed
```

Start the program 

```bash
  javac PathFinder.java
```


## Tech Stack

**Client:** No client side

**Programming Language: Java** 

## Optimizations ‼❗❗❗❗❗

For the A*  Search algorithm, due to the larger dataset, it turns to run a little bit slow, currently looking for ways to improve the A* algorithm for my Search
The breadth first search does justice job by returning a route once it finds it

## Lessons Learned

* Datasets for testing algorithms sometimes become hard to clean up if there are so much inconsistency
* Always measure the efficiency of an algorithm with a larg input size of data to see how it behaves in response to increasing input size
*
## Contributing

Contributions are always welcome!

See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.







## License

[MIT](https://choosealicense.com/licenses/mit/)

