# NIA_Differential_Evolution


The package differentialEvolution is an implementation of the correspondent continuous optimization algorithm. In this example, it is applied to maximize profit when selling energy coming from three different power plants to three different markets. 
Possible solutions assign values to 9 variables, namely energy amount produced (three values since we have three plants), energy amount intended to be sold (three values - three markets) and price (three values - three markets).




public class DifferentialEvolution


Executes the algorithm by initializing a population and performing differential evolution on it. 




public class Evaluation


This class reads in the problems that we want to optimize profit for that are provided as csv-files. Here, you can tune the parameters. Then, Differential Evolution is called with your params. The result is the maximal profit, i.e. the best existing member of the population when the main loop stops iterating.




public class Market


Object that describes a market. Its attributes are the maximum demand that occurs in the market and the maximum price you can sell your energy at. 




public class Plant


Object that describes a plant. Attributes are a number of kwH per plant that can be acieved, the cost of buying one item and a maximum number of plants. 




public class Initialization


This class initializes a population.




public class DonorGeneration


To perform mutation on one vector, a donor is generated. 




public class TrialGeneration


The donor and the original vector are recombined to form a trial.




public class Selection


Either trial or original are selected to get into the new population. The vector with higher profit is selected.




Tunable parameters


- base vector scheme: Random/Best/Target-to-Best; default is Random
- number of shifting directions: default is 1
- crossover scheme: Binary/Exponential; default is Binary
