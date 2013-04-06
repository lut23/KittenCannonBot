package operators

import groovy.transform.ToString
import java.util.Random

class TournamentSelection{
    Integer tournamentSize = 10
    Random r = new Random()
    def select(population){
        def s = population[r.nextInt(population.size())]
        def sQuality = s.quality()
        for(i in 2..tournamentSize) {
            def n = population[r.nextInt(population.size())]
            def nQuality = n.quality()
            if(nQuality > sQuality){
                s = n
                sQuality = nQuality
            }
        }
		return s
    }
    String toString() {
        "TS_" + tournamentSize
    }
}