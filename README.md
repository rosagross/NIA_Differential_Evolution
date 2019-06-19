# NIA_Differential_Evolution


The package differentialEvolution is an implementation of the correspondent continuous optimization algorithm. In this example, it is applied to maximize profit when selling energy coming from three different power plants to three different markets. 
Possible solutions assign values to 9 variables, namely energy amount produced (three values since we have three plants), energy amount intended to be sold (three values - three markets) and price (three values - three markets).


public class DifferentialEvolution


Implements the algorithm by initializing a population and performing differential evolution on it. 




public class Evaluation


This class reads in the problems that we want to optimize profit for. They are provided as csv-files. Here, you can tune the parameters. Then, Differential Evolution is called with your params. 




public class Market


Object that describes a market. 




public class Plant


Object that describes a plant. 




public class Initialization


This class initializes a population.




public class DonorGeneration


To perform mutation on one vector, a donor is generated. 




public class TrialGeneration


The donor and the original vector are recombined to form a trial.




public class Selection


Either trial or original are selected to get into the new population. The vector with higher profit is selected.




Tunable parameters


