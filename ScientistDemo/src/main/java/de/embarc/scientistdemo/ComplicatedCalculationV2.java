package de.embarc.scientistdemo;


    public class ComplicatedCalculationV2
    {
        public ComplicatedCalculationV2()
        {
        }

        public int getResult(int context)
        {
            /**
             * DO AWESOME COMPLICATED STUFF
             */

             // FOR Demo purposes

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            switch (context)
            {
                case 1:
                    return context + context;
                case 2:
                    return context * context;
                case 3:
                return context + (context + 1 ) * context;
                default:
                    return context;
            }

        }
    }
