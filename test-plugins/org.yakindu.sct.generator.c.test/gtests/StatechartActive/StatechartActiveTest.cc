/* Generated by YAKINDU Statechart Tools code generator. */

#include "gtest/gtest.h"
#include "StatechartActive.h"

#include "sc_timer_service.h"



//! The timers are managed by a timer service. */
static sc_unit_timer_service_t timer_service;

static StatechartActive statechart;

class StatechartActiveTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechartActive_init(&statechart);
		sc_timer_service_init(
			&timer_service,
			0,
			(sc_run_cycle_fp) &statechartActive_runCycle,
			false,
			200,
			&statechart
		);
	}
};


TEST_F(StatechartActiveTest, inactiveBeforeEnter) {
	EXPECT_TRUE(!statechartActive_isActive(&statechart));
}
TEST_F(StatechartActiveTest, activeAfterEnter) {
	statechartActive_enter(&statechart);
	EXPECT_TRUE(statechartActive_isActive(&statechart));
}
TEST_F(StatechartActiveTest, inactiveAfterExit) {
	statechartActive_enter(&statechart);
	statechartActive_exit(&statechart);
	EXPECT_TRUE(!statechartActive_isActive(&statechart));
}
TEST_F(StatechartActiveTest, activeAfterReenter) {
	statechartActive_enter(&statechart);
	statechartActive_exit(&statechart);
	statechartActive_enter(&statechart);
	EXPECT_TRUE(statechartActive_isActive(&statechart));
}


